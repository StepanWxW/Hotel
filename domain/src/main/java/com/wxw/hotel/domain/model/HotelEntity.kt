package com.wxw.hotel.domain.model

data class HotelEntity(
    val id: Int,
    val name: String,
    val address: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val imageUrls: List<String>,
    val aboutTheHotelEntity: AboutTheHotelEntity
)
