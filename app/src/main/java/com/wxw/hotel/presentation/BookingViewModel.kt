package com.wxw.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.repository.BookingRepositoryImpl
import com.wxw.hotel.domain.model.BookingEntity
import com.wxw.hotel.domain.usecase.GetBookingUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookingViewModel: ViewModel() {

    val roomRepositoryImpl = BookingRepositoryImpl()
    val getBookingUseCase = GetBookingUseCase(roomRepositoryImpl)

    private var bookingLive = MutableLiveData<BookingEntity>()
    val bookingLiveData: LiveData<BookingEntity> = bookingLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            loadBooking()
        }
    }
    private suspend fun loadBooking(){
        val booking = getBookingUseCase.loadBooking()
        bookingLive.postValue(booking)
    }

}