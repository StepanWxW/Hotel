package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.databinding.ItemTouristBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.TouristItem

class TouristDelegate : AbsListItemAdapterDelegate<TouristItem, Any, TouristDelegate.TouristItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TouristItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTouristBinding.inflate(inflater, parent, false)
        return TouristItemViewHolder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is TouristItem
    }

    override fun onBindViewHolder(item: TouristItem, holder: TouristItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    inner class TouristItemViewHolder(private val binding: ItemTouristBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TouristItem) {
            binding.textViewCountTourist.text = item.count
        }
    }
}