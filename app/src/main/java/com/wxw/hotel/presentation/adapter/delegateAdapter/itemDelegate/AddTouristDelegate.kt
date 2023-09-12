package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.databinding.ItemAddTouristBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.AddTouristItem

class AddTouristDelegate(private val clickListener: DelegateClickListener) : AbsListItemAdapterDelegate<AddTouristItem, Any, AddTouristDelegate.AddTouristItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): AddTouristItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAddTouristBinding.inflate(inflater, parent, false)
        return AddTouristItemViewHolder(binding)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is AddTouristItem
    }

    override fun onBindViewHolder(item: AddTouristItem, holder: AddTouristItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
        holder.bindAddTouristClickListener()
    }

    inner class AddTouristItemViewHolder(private val binding: ItemAddTouristBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AddTouristItem) {}
        fun bindAddTouristClickListener() {
            binding.buttonAddTourist.setOnClickListener {
                clickListener.onAddTouristClick()
            }
        }
    }
}