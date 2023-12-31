package com.wxw.hotel.domain.usecase

import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.repository.HotelRepository

class GetHotelUseCase(private val hotelRepository: HotelRepository) {

    suspend fun loadHotel() : HotelEntity{
       return hotelRepository.loadHotel()
    }
}