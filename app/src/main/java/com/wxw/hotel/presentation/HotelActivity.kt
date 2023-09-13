package com.wxw.hotel.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityHotelBinding
import com.wxw.hotel.presentation.adapter.ImageAdapter
import com.wxw.hotel.presentation.adapter.PeculiaritiesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelActivity : AppCompatActivity() {
    private val viewModel by viewModel<HotelViewModel>()
    
    private lateinit var binding : ActivityHotelBinding
    
    @SuppressLint("SetTextI18n", "StringFormatInvalid", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerImg = binding.carouselLayout.viewPager
        setSettingItemDetails()
        val recyclerViewPeculiarities = PeculiaritiesAdapter
            .getRecyclerViewSettings(binding.recyclerViewPeculiarities, this)

        viewModel.hotelLiveData.observe(this){
            val adapterImg = ImageAdapter(it.imageUrls)
            viewPagerImg.adapter = adapterImg
            with(binding) {
                carouselLayout.dotsIndicator.setViewPager2(viewPagerImg)
                itemRating.ratingCard.textRating.text = "${it.rating} ${it.ratingName}"
                itemRating.placeButton.text = it.address
                textPrice.text = getString(R.string.price_format, it.minimalPrice)
                textPriceForIt.text= it.priceForIt
            }
            val adapterPeculiarities = PeculiaritiesAdapter(it.aboutTheHotelEntity.peculiarities)
            recyclerViewPeculiarities.adapter = adapterPeculiarities
            binding.textViewDescription.text = it.aboutTheHotelEntity.description
        }
        binding.selectionRoom.setOnClickListener {
            val intent = Intent(this, RoomsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setSettingItemDetails() {
        with(binding.itemDetails) {
            itemButtonFacilities.name.text = getString(R.string.facilities_label)
            itemButtonFacilities.imageButton.setImageResource(R.drawable.emoji_happy)
            itemButtonIncluded.name.text = getString(R.string.included_label)
            itemButtonIncluded.imageButton.setImageResource(R.drawable.tick_square)
            itemButtonNotIncluded.name.text = getString(R.string.not_included_label)
            itemButtonNotIncluded.imageButton.setImageResource(R.drawable.close_square)
        }
    }
}