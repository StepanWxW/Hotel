package com.template.hotel.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.template.hotel.data.mapper.HotelMapper
import com.template.hotel.data.network.ApiFactory
import com.template.hotel.domain.HotelEntity
import com.template.hotel.domain.HotelRepository

class HotelRepositoryImpl: HotelRepository {
    private val apiService =  ApiFactory.apiService
    private val mapper = HotelMapper()
    override suspend fun loadHotel(): LiveData<HotelEntity> {
        val hotel: MutableLiveData<HotelEntity> = MutableLiveData()
        val hotelDto = apiService.getHotelDto()
        val hotelEntity = mapper.mapDtoToEntityHotel(hotelDto)
        hotel.value = hotelEntity
        return hotel

//        return Transformations.map(hotelDto) {
//            mapper.mapDtoToEntityHotel(it)
//        }
    }

}