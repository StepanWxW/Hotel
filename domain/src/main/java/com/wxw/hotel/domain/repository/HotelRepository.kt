package com.wxw.hotel.domain.repository

import com.wxw.hotel.domain.model.HotelEntity

interface HotelRepository {
    suspend fun loadHotel() : HotelEntity
}