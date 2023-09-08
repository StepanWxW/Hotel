package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class DelegateAdapterBooking : ListDelegationAdapter<List<Any>>() {

    init {
        delegatesManager.addDelegate(RatingItemDelegate())
        delegatesManager.addDelegate(InfoBookingItemDelegate())
        delegatesManager.addDelegate(PhoneItemDelegate())
    }
}