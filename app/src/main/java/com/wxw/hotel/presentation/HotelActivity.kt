package com.wxw.hotel.presentation


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityHotelBinding
import com.wxw.hotel.presentation.adapter.ImageAdapter
import com.wxw.hotel.presentation.adapter.PeculiaritiesAdapter


class HotelActivity : AppCompatActivity() {
    private lateinit var viewModel: HotelViewModel
    
    private lateinit var binding : ActivityHotelBinding
    
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[HotelViewModel::class.java]
        val viewPagerImg = binding.hotelCardLayout.carouselLayout.viewPager
        setSettingItemDetails()
        val recyclerViewPeculiarities = PeculiaritiesAdapter
            .getRecyclerViewSettings(binding.aboutHotelCardLayout.recyclerView, this)

        viewModel.hotelLiveData.observe(this){
            val adapterImg = ImageAdapter(it.imageUrls)
            viewPagerImg.adapter = adapterImg
            with(binding.hotelCardLayout) {
                carouselLayout.dotsIndicator.setViewPager2(viewPagerImg)
                itemRating.ratingCard.textRating.text = "${it.rating} ${it.ratingName}"
                itemRating.placeButton.text = it.address
                textPrice.text = "от " + it.minimalPrice.toString() + " ₽"
                textPriceForIt.text= it.priceForIt
            }
            val adapterPeculiarities = PeculiaritiesAdapter(it.aboutTheHotelEntity.peculiarities)
            recyclerViewPeculiarities.adapter = adapterPeculiarities
            binding.aboutHotelCardLayout.textViewDescription.text = it.aboutTheHotelEntity.description
        }
        binding.selectionRoom.setOnClickListener {
            val intent = Intent(this, RoomsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setSettingItemDetails() {
        with(binding.aboutHotelCardLayout.itemDetails) {
            itemButtonFacilities.name.text = "Удобства"
            itemButtonFacilities.imageButton.setImageResource(R.drawable.emoji_happy)
            itemButtonIncluded.name.text = "Что включено"
            itemButtonIncluded.imageButton.setImageResource(R.drawable.tick_square)
            itemButtonNotIncluded.name.text = "Что не включено"
            itemButtonNotIncluded.imageButton.setImageResource(R.drawable.close_square)
        }
    }
}