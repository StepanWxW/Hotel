package com.wxw.hotel.di

import com.wxw.hotel.domain.usecase.GetBookingUseCase
import com.wxw.hotel.domain.usecase.GetHotelUseCase
import com.wxw.hotel.domain.usecase.GetRoomsUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetHotelUseCase(get()) }
    single { GetBookingUseCase(get()) }
    single { GetRoomsUseCase(get()) }
}