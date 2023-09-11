package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.databinding.ItemInfoPriceBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.InfoPriceItem

class InfoPriceDelegate : AbsListItemAdapterDelegate<InfoPriceItem, Any, InfoPriceDelegate.InfoPriceItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): InfoPriceItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInfoPriceBinding.inflate(inflater, parent, false)
        return InfoPriceItemViewHolder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is InfoPriceItem
    }

    override fun onBindViewHolder(
        item: InfoPriceItem,
        holder: InfoPriceItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    inner class InfoPriceItemViewHolder(private val binding: ItemInfoPriceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InfoPriceItem) {
            binding.tourPrice.text = item.tourPrice
            binding.FuelSurchargePrice.text = item.fuelCharge
            binding.ServiceFreePrice.text = item.serviceCharge
            binding.TotalPrice.text = item.totalPrice
        }
    }
}