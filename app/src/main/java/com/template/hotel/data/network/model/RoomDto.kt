package com.template.hotel.data.network.model

class RoomDto (
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imagesUrl: List<String>
        )