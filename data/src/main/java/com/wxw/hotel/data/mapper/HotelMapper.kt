package com.wxw.hotel.data.mapper

import com.wxw.hotel.data.network.model.AboutTheHotelDto
import com.wxw.hotel.data.network.model.HotelDto
import com.wxw.hotel.data.network.model.RoomDto
import com.wxw.hotel.domain.model.AboutTheHotelEntity
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.model.RoomEntity

class HotelMapper {
    fun mapDtoToEntityHotel(dto: HotelDto): HotelEntity {
        return HotelEntity(
            id = dto.id,
            name = dto.name,
            address = dto.address,
            minimalPrice = dto.minimalPrice,
            priceForIt = dto.priceForIt,
            rating = dto.rating,
            ratingName = dto.ratingName,
            imageUrls = dto.imageUrls,
            aboutTheHotelEntity = mapDtoToEntityAboutTheHotel(dto.aboutTheHotel)
        )
    }
    private fun mapDtoToEntityAboutTheHotel(dto: AboutTheHotelDto): AboutTheHotelEntity {
        return AboutTheHotelEntity(
            description = dto.description,
            peculiarities = dto.peculiarities
        )
    }

    fun mapDtoToEntityRooms(dtoRooms: List<RoomDto>): List<RoomEntity> {
        return dtoRooms.map { mapDtoToEntityRoom(it) }
    }
    private fun mapDtoToEntityRoom(dto: RoomDto): RoomEntity{
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