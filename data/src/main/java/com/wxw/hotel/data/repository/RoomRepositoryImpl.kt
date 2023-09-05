package com.wxw.hotel.data.repository

import com.wxw.hotel.data.mapper.HotelMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.repository.RoomRepository

class RoomRepositoryImpl: RoomRepository {
    private val apiService =  ApiFactory.apiService
    private val mapper = HotelMapper()
    override suspend fun loadRooms(): List<RoomEntity> {
        val roomsResponse = apiService.getRoomsResponse()
        return mapper.mapDtoToEntityRooms(roomsResponse.rooms)
    }
}