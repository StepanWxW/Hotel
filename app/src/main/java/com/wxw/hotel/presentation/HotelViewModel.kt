package com.wxw.hotel.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.exeption.HotelLoadException
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.usecase.GetHotelUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel(private val getHotelUseCase: GetHotelUseCase) : ViewModel() {

    private val hotelLive = MutableLiveData<HotelEntity>()
    val hotelLiveData: LiveData<HotelEntity> = hotelLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loadHotel()
            } catch (e: HotelLoadException) {
                Log.d("MyError", e.toString())
            }
        }
    }

    private suspend fun loadHotel() {
        val hotel = getHotelUseCase.loadHotel()
        hotelLive.postValue(hotel)
    }
}