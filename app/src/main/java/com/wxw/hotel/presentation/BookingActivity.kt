package com.wxw.hotel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.databinding.ActivityBookingBinding

class BookingActivity : AppCompatActivity() {
    private lateinit var viewModel: BookingViewModel

    private lateinit var binding : ActivityBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BookingViewModel::class.java]

        viewModel.bookingLiveData.observe(this){
            Log.d("MyTag",it.arrivalCountry)
        }
    }
}