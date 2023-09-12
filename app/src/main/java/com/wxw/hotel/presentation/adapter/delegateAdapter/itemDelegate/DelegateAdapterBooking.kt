package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class DelegateAdapterBooking(delegateClickListener: DelegateClickListener) : ListDelegationAdapter<List<Any>>() {

    init {
        delegatesManager.addDelegate(RatingItemDelegate())
        delegatesManager.addDelegate(InfoBookingItemDelegate())
        delegatesManager.addDelegate(PhoneItemDelegate())
        delegatesManager.addDelegate(TouristDelegate())
        delegatesManager.addDelegate(InfoPriceDelegate())
        delegatesManager.addDelegate(AddTouristDelegate(delegateClickListener))
        delegatesManager.addDelegate(PriceButtonDelegate(delegateClickListener))
    }
}