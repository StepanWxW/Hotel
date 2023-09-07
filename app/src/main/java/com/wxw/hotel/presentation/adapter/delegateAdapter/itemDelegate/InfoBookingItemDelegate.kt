package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.databinding.ItemInfoBookingBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.InfoBookingItem

class InfoBookingItemDelegate : AbsListItemAdapterDelegate<InfoBookingItem, Any, InfoBookingItemDelegate.InfoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): InfoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInfoBookingBinding.inflate(inflater, parent, false)
        return InfoItemViewHolder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is InfoBookingItem
    }

    override fun onBindViewHolder(item: InfoBookingItem, holder: InfoItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    inner class InfoItemViewHolder(private val binding: ItemInfoBookingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InfoBookingItem) {
            binding.departure.text = item.departure
            binding.arrivalCountry.text = item.arrivalCountry
            binding.date.text = item.tourDateStartStop
            binding.numberOfNights.text = item.numberOfNights
            binding.room.text = item.room
            binding.nutrition.text = item.nutrition
        }
    }
}