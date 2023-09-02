package com.wxw.hotel.data.network

import com.wxw.hotel.data.network.model.BookingDto
import com.wxw.hotel.data.network.model.HotelDto
import com.wxw.hotel.data.network.model.RoomDto
import retrofit2.http.GET

interface ApiService {

    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelDto(): HotelDto

    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRoomsDto(): List<RoomDto>

    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingDto(): BookingDto

}