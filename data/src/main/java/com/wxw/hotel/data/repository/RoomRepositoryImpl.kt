package com.wxw.hotel.data.repository

import com.wxw.hotel.data.exeption.RoomLoadException
import com.wxw.hotel.data.mapper.RoomsMapper
import com.wxw.hotel.data.network.ApiService
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.repository.RoomRepository

class RoomRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: RoomsMapper
) : RoomRepository {

    override suspend fun loadRooms(): List<RoomEntity> {
        try {
            val roomsResponse = apiService.getRoomsResponse()
            return mapper.mapDtoToEntityRooms(roomsResponse.rooms)
        } catch (e: Exception) {
            throw RoomLoadException("Failed to load rooms data", e)
        }
    }
}