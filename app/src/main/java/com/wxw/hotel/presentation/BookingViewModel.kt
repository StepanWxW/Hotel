package com.wxw.hotel.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.exeption.BookingLoadException
import com.wxw.hotel.domain.model.BookingEntity
import com.wxw.hotel.domain.usecase.GetBookingUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookingViewModel(private val getBookingUseCase: GetBookingUseCase) : ViewModel() {

    private var bookingLive = MutableLiveData<BookingEntity>()
    val bookingLiveData: LiveData<BookingEntity> = bookingLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loadBooking()
            } catch (e: BookingLoadException) {
                Log.d("MyError", e.toString())
            }
        }
    }

    private suspend fun loadBooking() {
        val booking = getBookingUseCase.loadBooking()
        bookingLive.postValue(booking)
    }
}