package com.wxw.hotel.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wxw.hotel.R


class HotelActivity : AppCompatActivity() {
    private lateinit var viewModel: HotelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        viewModel = ViewModelProvider(this)[HotelViewModel::class.java]
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotsIndicator)
        val rating = findViewById<TextView>(R.id.textRating)

        viewModel.hotelLive.observe(this){
            val adapter = ImageAdapter(it.imageUrls)
            viewPager2.adapter = adapter
            dotsIndicator.setViewPager2(viewPager2)
            rating.text = "${it.rating} ${it.ratingName}"
        }
    }
}