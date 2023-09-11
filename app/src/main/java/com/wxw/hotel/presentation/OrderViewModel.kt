package com.wxw.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class OrderViewModel: ViewModel() {

    private var intRandomLive = MutableLiveData<Int>()
    val intRandomLiveData: LiveData<Int> = intRandomLive

    init {
        val randomInt = Random.nextInt(100000, 999999)
        intRandomLive.value = randomInt
    }
}