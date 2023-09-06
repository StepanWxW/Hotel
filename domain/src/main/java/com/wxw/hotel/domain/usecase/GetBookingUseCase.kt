package com.wxw.hotel.domain.usecase

import com.wxw.hotel.domain.model.BookingEntity
import com.wxw.hotel.domain.repository.BookingRepository

class GetBookingUseCase(private val bookingRepository: BookingRepository) {

    suspend fun loadBooking() : BookingEntity {
        return bookingRepository.loadBooking()
    }
}