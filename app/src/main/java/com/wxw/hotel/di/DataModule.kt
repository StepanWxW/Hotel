package com.wxw.hotel.di

import com.wxw.hotel.data.mapper.BookingMapper
import com.wxw.hotel.data.mapper.HotelMapper
import com.wxw.hotel.data.mapper.RoomsMapper
import com.wxw.hotel.data.network.ApiFactory

import com.wxw.hotel.data.network.ApiService
import com.wxw.hotel.data.repository.BookingRepositoryImpl
import com.wxw.hotel.data.repository.HotelRepositoryImpl
import com.wxw.hotel.data.repository.RoomRepositoryImpl
import com.wxw.hotel.domain.repository.BookingRepository
import com.wxw.hotel.domain.repository.HotelRepository
import com.wxw.hotel.domain.repository.RoomRepository
import org.koin.dsl.module

val dataModule = module {
    single<ApiService> { ApiFactory.apiService }
    single { BookingMapper() }
    single { HotelMapper() }
    single { RoomsMapper() }
    single<BookingRepository> { BookingRepositoryImpl(get(), get()) }
    single<HotelRepository> { HotelRepositoryImpl(get(), get()) }
    single<RoomRepository> { RoomRepositoryImpl(get(), get()) }
}