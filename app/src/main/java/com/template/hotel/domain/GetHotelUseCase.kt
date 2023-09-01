package com.template.hotel.domain

import androidx.lifecycle.LiveData

class GetHotelUseCase(private val hotelRepository: HotelRepository) {

    suspend fun loadHotel() : LiveData<HotelEntity>{
       return hotelRepository.loadHotel()
    }
}