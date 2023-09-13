package com.wxw.hotel.data.repository

import com.wxw.hotel.data.exeption.RoomLoadException
import com.wxw.hotel.data.mapper.RoomsMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.repository.RoomRepository

class RoomRepositoryImpl : RoomRepository {
    private val apiService = ApiFactory.apiService
    private val mapper = RoomsMapper()

    override suspend fun loadRooms(): List<RoomEntity> {
        try {
            val roomsResponse = apiService.getRoomsResponse()
            return mapper.mapDtoToEntityRooms(roomsResponse.rooms)
        } catch (e: Exception) {
            throw RoomLoadException("Failed to load rooms data", e)
        }
    }
}