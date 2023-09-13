package com.wxw.hotel.di

import com.wxw.hotel.data.repository.BookingRepositoryImpl
import com.wxw.hotel.data.repository.HotelRepositoryImpl
import com.wxw.hotel.data.repository.RoomRepositoryImpl
import com.wxw.hotel.domain.repository.BookingRepository
import com.wxw.hotel.domain.repository.HotelRepository
import com.wxw.hotel.domain.repository.RoomRepository
import com.wxw.hotel.domain.usecase.GetBookingUseCase
import com.wxw.hotel.domain.usecase.GetHotelUseCase
import com.wxw.hotel.domain.usecase.GetRoomsUseCase
import com.wxw.hotel.presentation.BookingViewModel
import com.wxw.hotel.presentation.HotelViewModel
import com.wxw.hotel.presentation.OrderViewModel
import com.wxw.hotel.presentation.RoomsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.random.Random

val appModule = module {
    single<HotelRepository> { HotelRepositoryImpl() }
    single { GetHotelUseCase(get()) }
    viewModel { HotelViewModel(get()) }

    single<BookingRepository> { BookingRepositoryImpl() }
    single { GetBookingUseCase(get()) }
    viewModel { BookingViewModel(get()) }

    single<RoomRepository> { RoomRepositoryImpl() }
    single { GetRoomsUseCase(get()) }
    viewModel { RoomsViewModel(get()) }

    viewModel { OrderViewModel(get()) }
    factory { Random.nextInt(100000, 999999) }
}
