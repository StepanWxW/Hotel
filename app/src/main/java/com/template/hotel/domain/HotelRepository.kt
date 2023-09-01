package com.template.hotel.domain

import androidx.lifecycle.LiveData

interface HotelRepository {
    suspend fun loadHotel() : LiveData<HotelEntity>
}