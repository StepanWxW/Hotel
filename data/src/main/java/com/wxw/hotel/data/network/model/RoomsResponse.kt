package com.wxw.hotel.data.network.model

import com.google.gson.annotations.SerializedName

class RoomsResponse(
    @SerializedName("rooms") val rooms: List<RoomDto>
)

