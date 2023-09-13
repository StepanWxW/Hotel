package com.wxw.hotel.data.repository

import com.wxw.hotel.data.exeption.HotelLoadException
import com.wxw.hotel.data.mapper.HotelMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.repository.HotelRepository

class HotelRepositoryImpl : HotelRepository {
    private val apiService = ApiFactory.apiService
    private val mapper = HotelMapper()

    override suspend fun loadHotel(): HotelEntity {
        try {
            val hotelDto = apiService.getHotelDto()
            return mapper.mapDtoToEntityHotel(hotelDto)
        } catch (e: Exception) {
            throw HotelLoadException("Failed to load hotel data", e)
        }
    }
}