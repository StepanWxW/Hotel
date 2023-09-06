package com.wxw.hotel.data.mapper

import com.wxw.hotel.data.network.model.room.RoomDto
import com.wxw.hotel.domain.model.RoomEntity

class RoomsMapper {
    fun mapDtoToEntityRooms(dtoRooms: List<RoomDto>): List<RoomEntity> {
        return dtoRooms.map { mapDtoToEntityRoom(it) }
    }
    private fun mapDtoToEntityRoom(dto: RoomDto): RoomEntity {
        return RoomEntity(
            id = dto.id,
            name = dto.name,
            price = dto.price,
            pricePer = dto.pricePer,
            peculiarities = dto.peculiarities,
            imagesUrl = dto.imagesUrl
        )
    }
}