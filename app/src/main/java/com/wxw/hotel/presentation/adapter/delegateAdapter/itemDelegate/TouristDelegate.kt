package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.R
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
        private val arrowImageView: ImageView = binding.arrowImageView
        private val detailsLayout = binding.detailsLayout
        fun bind(item: TouristItem) {
            binding.textViewCountTourist.text = item.count

            arrowImageView.setOnClickListener {
                if (detailsLayout.visibility == View.VISIBLE) {
                    detailsLayout.visibility = View.GONE
                    arrowImageView.setImageResource(R.drawable.arrow_down)
                } else {
                    detailsLayout.visibility = View.VISIBLE
                    arrowImageView.setImageResource(R.drawable.arrow_top)
                }
            }
        }
    }
}