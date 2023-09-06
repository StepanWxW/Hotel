package com.wxw.hotel.data.network.model.room

import com.google.gson.annotations.SerializedName

class RoomsResponse(
    @SerializedName("rooms") val rooms: List<RoomDto>
)

