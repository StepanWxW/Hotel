package com.template.hotel.data.mapper

import com.template.hotel.data.network.model.AboutTheHotelDto
import com.template.hotel.data.network.model.HotelDto
import com.template.hotel.domain.AboutTheHotelEntity
import com.template.hotel.domain.HotelEntity

class HotelMapper {
    fun mapDtoToEntityHotel(dto: HotelDto): HotelEntity{
        return HotelEntity(
            id = dto.id,
            name = dto.name,
            address = dto.address,
            minimal_price = dto.minimal_price,
            priceForIt = dto.priceForIt,
            rating = dto.rating,
            ratingName = dto.ratingName,
            image_urls = dto.image_urls,
            aboutTheHotelEntity = mapDtoToEntityAboutTheHotel(dto.aboutTheHotel)
        )
    }
    private fun mapDtoToEntityAboutTheHotel(dto: AboutTheHotelDto): AboutTheHotelEntity{
        return AboutTheHotelEntity(
            description = dto.description,
            peculiarities = dto.peculiarities
        )
    }
}