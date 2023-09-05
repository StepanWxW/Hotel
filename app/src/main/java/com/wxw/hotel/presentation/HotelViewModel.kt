package com.wxw.hotel.presentation

import androidx.lifecycle.LiveData
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

    private var hotelLive = MutableLiveData<HotelEntity>()
    val hotelLiveData: LiveData<HotelEntity> = hotelLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            loadHotel()
        }
    }
    private suspend fun loadHotel(){
        val hotel = getHotelUseCase.loadHotel()
        hotelLive.postValue(hotel)
    }
}