package com.wxw.hotel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.R

class HotelActivity : AppCompatActivity() {
    private lateinit var viewModel: HotelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        viewModel = ViewModelProvider(this)[HotelViewModel::class.java]
        viewModel.hotelLive.observe(this){

        }
    }
}