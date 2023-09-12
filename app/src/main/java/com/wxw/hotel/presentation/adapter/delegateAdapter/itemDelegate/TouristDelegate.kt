package com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ItemTouristBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.TouristItem

class TouristDelegate : AbsListItemAdapterDelegate<TouristItem, Any, TouristDelegate.TouristItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TouristItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTouristBinding.inflate(inflater, parent, false)
        val tourist = TouristItemViewHolder(binding)
        allInstances.add(tourist)
        return tourist
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is TouristItem
    }

    override fun onBindViewHolder(item: TouristItem, holder: TouristItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    inner class TouristItemViewHolder(private val binding: ItemTouristBinding) : RecyclerView.ViewHolder(binding.root) {
        private var nameValid: Boolean = false
        private var surnameValid: Boolean = false
        private var dateValid: Boolean = false
        private var citizenshipValid: Boolean = false
        private var passportNumberValid: Boolean = false
        private var passportPeriodValid: Boolean = false
        init {
            binding.arrowImageView.setOnClickListener {
                openClose()
            }
            setupTextChangeListener(binding.inputName, binding.cardName) { nameValid = true }
            setupTextChangeListener(binding.inputSurname, binding.cardView2Surname) { surnameValid = true }
            setupTextChangeListener(binding.inputDateOfBirth, binding.cardView2Date) { dateValid = true }
            setupTextChangeListener(binding.inputCitizenship, binding.cardView2Citizenship) { citizenshipValid = true }
            setupTextChangeListener(binding.inputPassportNumber, binding.cardView2PassportNumber) { passportNumberValid = true }
            setupTextChangeListener(binding.inputValidityPeriod, binding.cardView2PassportValidityPeriod) { passportPeriodValid = true }
        }
        private fun setupTextChangeListener(editText: EditText, cardView: CardView, validField: () -> Unit) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(editable: Editable?) {
                    val inputText = editable.toString()
                    if (inputText.isNotEmpty()) {
                        validField()
                        cardView.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.light_grey2))
                    } else {
                        validField()
                    }
                }
            })
        }
        fun bind(item: TouristItem) {
            binding.textViewCountTourist.text = item.count
        }

        private fun openClose() {
            with(binding) {
                if (detailsLayout.visibility == View.VISIBLE) {
                    detailsLayout.visibility = View.GONE
                    arrowImageView.setImageResource(R.drawable.arrow_down)
                } else {
                    detailsLayout.visibility = View.VISIBLE
                    arrowImageView.setImageResource(R.drawable.arrow_top)
                }
            }
        }
        fun checkValid(): Boolean {
            val fieldsToCheck = listOf(
                Pair(nameValid, binding.cardName),
                Pair(surnameValid, binding.cardView2Surname),
                Pair(dateValid, binding.cardView2Date),
                Pair(citizenshipValid, binding.cardView2Citizenship),
                Pair(passportNumberValid, binding.cardView2PassportNumber),
                Pair(passportPeriodValid, binding.cardView2PassportValidityPeriod)
            )

            var isValid = true
            for ((isValidField, cardView) in fieldsToCheck) {
                if (!isValidField) {
                    binding.detailsLayout.visibility = View.VISIBLE
                    cardView.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.not_valid))
                    isValid = false
                }
            }
            return isValid
        }
    }
    companion object {
        val allInstances = mutableListOf<TouristItemViewHolder>()
        fun checkAllTouristItemsValid(): Boolean {
            var allValid = true
            allInstances.forEach { touristItem ->
                if (!touristItem.checkValid()) {
                    allValid = false
                }
            }
            return allValid
        }
    }
}