package com.wxw.hotel.domain.repository

import com.wxw.hotel.domain.model.RoomEntity

interface RoomRepository {
    suspend fun loadRooms() : List<RoomEntity>
}