package com.wxw.hotel.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wxw.hotel.R
import com.wxw.hotel.domain.model.RoomEntity
import com.wxw.hotel.presentation.BookingActivity

class RoomAdapter(private val rooms: List<RoomEntity>) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_room, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val room = rooms[position]
        holder.textViewNameRoom.text = room.name
        holder.textPrice.text = room.price.toString()
        holder.textPricePer.text = room.pricePer

        val imageAdapter = ImageAdapter(room.imagesUrl)
        holder.viewPagerImg.adapter = imageAdapter
        holder.dotsIndicator.setViewPager2(holder.viewPagerImg)

        val adapterPeculiarities = PeculiaritiesAdapter(room.peculiarities)
        holder.recyclerViewPeculiarities.adapter = adapterPeculiarities
        holder.selectionRoom.setOnClickListener{
            val intent = Intent(holder.itemView.context, BookingActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.carousel_layout_room)
        val viewPagerImg: ViewPager2 = constraintLayout.findViewById(R.id.viewPager)
        val dotsIndicator: DotsIndicator = constraintLayout.findViewById(R.id.dotsIndicator)
        val textViewNameRoom: TextView = itemView.findViewById(R.id.textViewNameRoom)
        val recyclerViewPeculiarities: RecyclerView = PeculiaritiesAdapter
            .getRecyclerViewSettings(itemView.findViewById(R.id.recyclerViewPeculiarities), itemView.context)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        val textPricePer: TextView = itemView.findViewById(R.id.textPricePer)
        val selectionRoom: Button = itemView.findViewById(R.id.changeRoom)
    }
}