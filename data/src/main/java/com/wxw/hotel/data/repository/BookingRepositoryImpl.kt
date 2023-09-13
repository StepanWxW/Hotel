package com.wxw.hotel.data.repository

import com.wxw.hotel.data.exeption.BookingLoadException
import com.wxw.hotel.data.mapper.BookingMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.BookingEntity
import com.wxw.hotel.domain.repository.BookingRepository

class BookingRepositoryImpl: BookingRepository {
    private val apiService =  ApiFactory.apiService
    private val mapper = BookingMapper()
    override suspend fun loadBooking(): BookingEntity {
        try {
            val bookingDto = apiService.getBookingDto()
            return mapper.mapDtoToEntityBooking(bookingDto)
        } catch (e: Exception) {
            throw BookingLoadException("Failed to load booking data", e)
        }
    }
}