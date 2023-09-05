package com.wxw.hotel.domain.model

class RoomEntity (
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imagesUrl: List<String>
)