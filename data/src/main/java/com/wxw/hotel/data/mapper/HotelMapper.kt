package com.wxw.hotel.data.mapper

import com.wxw.hotel.data.network.model.AboutTheHotelDto
import com.wxw.hotel.data.network.model.HotelDto
import com.wxw.hotel.domain.model.AboutTheHotelEntity
import com.wxw.hotel.domain.model.HotelEntity

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
}