package com.template.hotel.domain

class GetHotelUseCase(private val hotelRepository: HotelRepository) {
    fun getHotel() : Hotel{
       return hotelRepository.getHotel()
    }
}