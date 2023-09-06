package com.wxw.hotel.domain.repository

import com.wxw.hotel.domain.model.BookingEntity

interface BookingRepository {
    suspend fun loadBooking() : BookingEntity
}