package com.wxw.hotel.domain.usecase


import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.repository.RoomRepository

class GetRoomsUseCase(private val roomRepository: RoomRepository) {

    suspend fun loadRooms(): List<RoomEntity> {
        return roomRepository.loadRooms()
    }
}