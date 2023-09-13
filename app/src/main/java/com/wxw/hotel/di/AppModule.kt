package com.wxw.hotel.di

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

    single { GetHotelUseCase(get()) }
    viewModel { HotelViewModel(get()) }

    single { GetBookingUseCase(get()) }
    viewModel { BookingViewModel(get()) }

    single { GetRoomsUseCase(get()) }
    viewModel { RoomsViewModel(get()) }

    viewModel { OrderViewModel(get()) }
    factory { Random.nextInt(100000, 999999) }
}
