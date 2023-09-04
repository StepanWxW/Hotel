package com.wxw.hotel.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.repository.HotelRepositoryImpl
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.usecase.GetHotelUseCase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel: ViewModel() {
    val hotelRepositoryImpl = HotelRepositoryImpl()
    val getHotelUseCase = GetHotelUseCase(hotelRepositoryImpl)

    var hotelLive = MutableLiveData<HotelEntity>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            load()
        }
    }
    private suspend fun load(){
        val hotel = getHotelUseCase.loadHotel()
        hotelLive.postValue(hotel)
    }
}