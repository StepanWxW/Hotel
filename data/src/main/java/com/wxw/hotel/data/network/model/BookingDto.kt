package com.wxw.hotel.data.network.model

class BookingDto (
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val horating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val tourDateStart: String,
    val tourDateStop: String,
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    val tourPrice: Int,
    val fuelCharge: Int,
    val service_charge: Int
)
