package com.wxw.hotel.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.wxw.hotel.databinding.ItemPeculiaritiesBinding


class PeculiaritiesAdapter(private val data: List<String>) :
    RecyclerView.Adapter<PeculiaritiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPeculiaritiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = data[position]
        holder.binding.textView.text = text
    }
    override fun getItemCount(): Int = data.size
    inner class ViewHolder(val binding: ItemPeculiaritiesBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        fun getRecyclerViewSettings(recyclerView: RecyclerView, context: Context): RecyclerView {
            val layoutManager = FlexboxLayoutManager(context)
            layoutManager.flexDirection = FlexDirection.ROW
            layoutManager.flexWrap = FlexWrap.WRAP
            recyclerView.layoutManager = layoutManager
            return recyclerView
        }
    }
}