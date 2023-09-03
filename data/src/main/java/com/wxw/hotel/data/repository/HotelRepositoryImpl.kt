package com.wxw.hotel.data.repository

import android.util.Log
import com.wxw.hotel.data.mapper.HotelMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.AboutTheHotelEntity
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.repository.HotelRepository

class HotelRepositoryImpl: HotelRepository {
    private val apiService =  ApiFactory.apiService
    private val mapper = HotelMapper()
    override suspend fun loadHotel(): HotelEntity {
        try {
            val hotelDto = apiService.getHotelDto()
            return mapper.mapDtoToEntityHotel(hotelDto)
        } catch (e: Exception) {
            Log.d("Mytag", e.toString())
        }
        val list = listOf("sdf")
        val about = AboutTheHotelEntity("asdsa",list)
        return HotelEntity(123,"213","231",123, "123",123,"ewrw",
                list,  about)

//        return Transformations.map(hotelDto) {
//            mapper.mapDtoToEntityHotel(it)
//        }
    }

}