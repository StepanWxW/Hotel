package com.wxw.hotel.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wxw.hotel.data.mapper.HotelMapper
import com.wxw.hotel.data.network.ApiFactory
import com.wxw.hotel.domain.model.HotelEntity
import com.wxw.hotel.domain.repository.HotelRepository

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