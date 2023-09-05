package com.wxw.hotel.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wxw.hotel.data.repository.RoomRepositoryImpl
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.domain.usecase.GetRoomsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomsViewModel: ViewModel() {
    val roomRepositoryImpl = RoomRepositoryImpl()
    val getRoomsUseCase = GetRoomsUseCase(roomRepositoryImpl)

    private var roomLive = MutableLiveData<List<RoomEntity>>()
    val roomLiveData: LiveData<List<RoomEntity>> = roomLive

    init {
        CoroutineScope(Dispatchers.IO).launch {
            loadRooms()
        }
    }
    private suspend fun loadRooms(){
        val hotel = getRoomsUseCase.loadRooms()
        roomLive.postValue(hotel)
    }
}