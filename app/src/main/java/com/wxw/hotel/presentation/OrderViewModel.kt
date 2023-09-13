package com.wxw.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel(private val randomInt: Int) : ViewModel() {

    private var intRandomLive = MutableLiveData<Int>()
    val intRandomLiveData: LiveData<Int> = intRandomLive

    init {
        intRandomLive.value = randomInt
    }
}