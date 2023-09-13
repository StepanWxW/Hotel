package com.wxw.hotel.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.exeption.RoomLoadException
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.usecase.GetRoomsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomsViewModel(private val getRoomsUseCase: GetRoomsUseCase) : ViewModel() {

    private var roomLive = MutableLiveData<List<RoomEntity>>()
    val roomLiveData: LiveData<List<RoomEntity>> = roomLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loadRooms()
            } catch (e: RoomLoadException) {
                Log.d("MyError", e.toString())
            }
        }
    }

    private suspend fun loadRooms() {
        val rooms = getRoomsUseCase.loadRooms()
        roomLive.postValue(rooms)
    }
}