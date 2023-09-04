package com.wxw.hotel.presentation


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wxw.hotel.R


class HotelActivity : AppCompatActivity() {
    private lateinit var viewModel: HotelViewModel

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        viewModel = ViewModelProvider(this)[HotelViewModel::class.java]
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotsIndicator)
        val textRating = findViewById<TextView>(R.id.textRating)
        val placeButton = findViewById<Button>(R.id.placeButton)
        val textPrice = findViewById<TextView>(R.id.textPrice)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        recyclerView.layoutManager = layoutManager

        viewModel.hotelLive.observe(this){
            val adapterImg = ImageAdapter(it.imageUrls)
            viewPager2.adapter = adapterImg
            dotsIndicator.setViewPager2(viewPager2)
            textRating.text = "${it.rating} ${it.ratingName}"
            placeButton.text = it.address
            textPrice.text = "от "  + it.minimalPrice.toString() + " ₽"

            val adapterPeculiarities = PeculiaritiesAdapter(it.aboutTheHotelEntity.peculiarities)
            recyclerView.adapter = adapterPeculiarities
            textViewDescription.text = it.aboutTheHotelEntity.description
        }



    }
}