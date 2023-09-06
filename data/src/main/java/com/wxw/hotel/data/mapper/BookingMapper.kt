package com.wxw.hotel.data.mapper

import com.wxw.hotel.data.network.model.booking.BookingDto
import com.wxw.hotel.domain.model.BookingEntity

class BookingMapper {
    fun mapDtoToEntityBooking(bookingDto: BookingDto): BookingEntity {
        return BookingEntity(
            id = bookingDto.id,
            hotelName = bookingDto.hotelName,
            hotelAddress = bookingDto.hotelAddress,
            rating = bookingDto.rating,
            ratingName = bookingDto.ratingName,
            departure = bookingDto.departure,
            arrivalCountry = bookingDto.arrivalCountry,
            tourDateStart = bookingDto.tourDateStart,
            tourDateStop = bookingDto.tourDateStop,
            numberOfNights = bookingDto.numberOfNights,
            room = bookingDto.room,
            nutrition = bookingDto.nutrition,
            tourPrice = bookingDto.tourPrice,
            fuelCharge = bookingDto.fuelCharge,
            serviceCharge = bookingDto.serviceCharge
        )
    }
}