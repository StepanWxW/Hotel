package com.wxw.hotel.presentation.adapter.delegateAdapter.model

import java.text.NumberFormat
import java.util.Locale

class InfoPriceItem (
    val tourPrice: String,
    val fuelCharge: String,
    val serviceCharge: String,
    val totalPrice: String
) {
    constructor(tourPrice: Int, fuelCharge: Int, serviceCharge: Int) : this(
        tourPrice = formatPrice(tourPrice),
        fuelCharge = formatPrice(fuelCharge),
        serviceCharge = formatPrice(serviceCharge),
        totalPrice = formatPrice(tourPrice + fuelCharge + serviceCharge)
    )

    companion object {
        fun formatPrice(price: Int): String {
            val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
            val formattedPrice = numberFormat.format(price)
            return "$formattedPrice ₽"
        }
    }
}