package com.wxw.hotel.domain.repository

import androidx.lifecycle.LiveData
import com.wxw.hotel.domain.model.HotelEntity

interface HotelRepository {
    suspend fun loadHotel() : HotelEntity
}