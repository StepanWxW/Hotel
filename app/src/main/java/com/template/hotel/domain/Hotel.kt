package com.template.hotel.domain

data class Hotel(
    val id: Int,
    val name: String,
    val address: String,
    val minimal_price: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val image_urls: List<String>,
    val aboutTheHotel: AboutTheHotel
)
