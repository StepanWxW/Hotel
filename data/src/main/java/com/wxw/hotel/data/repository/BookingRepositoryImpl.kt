package com.wxw.hotel.data.repository

import com.wxw.hotel.data.exeption.BookingLoadException
import com.wxw.hotel.data.mapper.BookingMapper
import com.wxw.hotel.data.network.ApiService
import com.wxw.hotel.domain.model.BookingEntity
import com.wxw.hotel.domain.repository.BookingRepository

class BookingRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: BookingMapper
) : BookingRepository {
    override suspend fun loadBooking(): BookingEntity {
        try {
            val bookingDto = apiService.getBookingDto()
            return mapper.mapDtoToEntityBooking(bookingDto)
        } catch (e: Exception) {
            throw BookingLoadException("Failed to load booking data", e)
        }
    }
}