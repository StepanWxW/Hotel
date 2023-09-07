package com.wxw.hotel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityBookingBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate.DelegateAdapterBooking
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.InfoBookingItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.RatingItem

class BookingActivity : AppCompatActivity() {
    private lateinit var viewModel: BookingViewModel

    private lateinit var binding : ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BookingViewModel::class.java]
        val recyclerViewBooking = binding.recyclerViewBooking
        val delegateAdapterBooking = DelegateAdapterBooking()

        viewModel.bookingLiveData.observe(this) {
            val items = mutableListOf<Any>()
            items.add(RatingItem(it.hotelAddress, "${it.rating} ${it.ratingName}"))
            items.add(InfoBookingItem(
                departure = it.departure,
                arrivalCountry = it.arrivalCountry,
                tourDateStartStop = "${it.tourDateStart} - ${it.tourDateStop}",
                numberOfNights = "${it.numberOfNights} ночей",
                room = it.room,
                nutrition = it.nutrition
            ))
            delegateAdapterBooking.items = items
            recyclerViewBooking.adapter = delegateAdapterBooking

        }

        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}