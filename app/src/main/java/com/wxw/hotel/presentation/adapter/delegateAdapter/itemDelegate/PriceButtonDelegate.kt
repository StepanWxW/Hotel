package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.databinding.ItemButtonPriceBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.PriceButtonItem

class PriceButtonDelegate(private val clickListener: DelegateClickListener) : AbsListItemAdapterDelegate<PriceButtonItem, Any, PriceButtonDelegate.PriceButtonItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): PriceButtonItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemButtonPriceBinding.inflate(inflater, parent, false)
        return PriceButtonItemViewHolder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PriceButtonItem
    }

    override fun onBindViewHolder(
        item: PriceButtonItem,
        holder: PriceButtonItemViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    inner class PriceButtonItemViewHolder(private val binding: ItemButtonPriceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PriceButtonItem) {
            binding.priceTotalButton.text = item.totalPrice
            binding.priceTotalButton.setOnClickListener {
                clickListener.onPayClick()
            }
        }
    }
}