package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.R
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.RatingItem

class RatingItemDelegate : AbsListItemAdapterDelegate<RatingItem, Any, RatingItemDelegate.RatingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RatingItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_rating, parent, false)
        return RatingItemViewHolder(view)
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is RatingItem
    }

    override fun onBindViewHolder(item: RatingItem, holder: RatingItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    inner class RatingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardViewRating: CardView = itemView.findViewById(R.id.rating_card)
        private val placeButton: TextView = itemView.findViewById(R.id.placeButton)
        private val textRating: TextView = cardViewRating.findViewById(R.id.textRating)

        fun bind(item: RatingItem) {
            placeButton.text = item.hotelAddress
            textRating.text = item.rating
        }
    }
}





