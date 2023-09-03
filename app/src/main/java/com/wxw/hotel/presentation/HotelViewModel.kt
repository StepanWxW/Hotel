package com.wxw.hotel.presentation

import android.util.Log
import android.view.View
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

    val corut = CoroutineScope(Dispatchers.IO)
    init {
        corut.launch {
            load()
        }
    }
    private suspend fun load(){
        var hotel = getHotelUseCase.loadHotel()
        Log.d("Mytag", hotel.toString())
        hotelLive.postValue(hotel)
    }
}