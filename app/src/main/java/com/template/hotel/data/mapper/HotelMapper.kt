package com.template.hotel.data.mapper

import com.template.hotel.data.network.AboutTheHotelDto
import com.template.hotel.data.network.HotelDto
import com.template.hotel.domain.AboutTheHotel
import com.template.hotel.domain.Hotel

class HotelMapper {
    fun mapDtoToEntityHotel(dto: HotelDto): Hotel{
        return Hotel(
            id = dto.id,
            name = dto.name,
            address = dto.address,
            minimal_price = dto.minimal_price,
            priceForIt = dto.priceForIt,
            rating = dto.rating,
            ratingName = dto.ratingName,
            image_urls = dto.image_urls,
            aboutTheHotel = mapDtoToEntityAboutTheHotel(dto.aboutTheHotel)
        )
    }
    private fun mapDtoToEntityAboutTheHotel(dto: AboutTheHotelDto): AboutTheHotel{
        return AboutTheHotel(
            description = dto.description,
            peculiarities = dto.peculiarities
        )
    }
}