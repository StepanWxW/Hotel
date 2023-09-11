package com.wxw.hotel.presentation.adapter.delegateAdapter.model

import java.text.NumberFormat
import java.util.Locale

class PriceButtonItem(
    val totalPrice: String
) {
    constructor(totalPrice: Int) : this(
        formatPrice(totalPrice),
    )

    companion object {
        private fun formatPrice(price: Int): String {
            val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
            val formattedPrice = numberFormat.format(price)
            return "Оплатить $formattedPrice ₽"
        }
    }
}