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
import com.santalu.maskara.widget.MaskEditText
import com.wxw.hotel.R
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.PhoneItem


class PhoneItemDelegate : AbsListItemAdapterDelegate<PhoneItem, Any, PhoneItemDelegate.PhoneItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): PhoneItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_phone_email, parent, false)
        val phone = PhoneItemViewHolder(view)
        allInstances.add(phone)
        return phone
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is PhoneItem
    }

    override fun onBindViewHolder(item: PhoneItem, holder: PhoneItemViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    inner class PhoneItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var emailValid: Boolean = false
        private var phoneValid: Boolean = false
        val inputPhone: MaskEditText = itemView.findViewById(R.id.inputPhone)
        private val inputEmail: EditText = itemView.findViewById(R.id.inputEmail)
        private val cardView2Email: CardView = itemView.findViewById(R.id.cardView2Email)
        private val cardView2Phone: CardView = itemView.findViewById(R.id.item_phone)

        init {
            inputEmail.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    val email = inputEmail.text.toString()
                    emailValid = isEmailValid(email)
                    val colorResId = if (emailValid) R.color.light_grey2 else R.color.not_valid
                    cardView2Email.setCardBackgroundColor(ContextCompat.getColor(itemView.context, colorResId))
                }
            }

            inputEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(editable: Editable?) {
                    val inputText = editable.toString()
                    if(isEmailValid(inputText)){
                        cardView2Email.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.light_grey2))
                    }
                }
            })

            inputPhone.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(editable: Editable?) {
                    if(inputPhone.isDone){
                        val colorResId = if (phoneValid) R.color.light_grey2 else R.color.not_valid
                        cardView2Phone.setCardBackgroundColor(ContextCompat.getColor(itemView.context, colorResId))
                    }
                    phoneValid = inputPhone.isDone
                }
            })
        }
        fun bind(item: PhoneItem) {}
        fun isEmailValid(email: String): Boolean {
            emailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            return emailValid
        }
        fun checkValid(): Boolean {
            val isEmailValid = isEmailValid()
            val isPhoneValid = isPhoneValid()
            return isEmailValid && isPhoneValid
        }

        fun isEmailValid(): Boolean {
            if (!emailValid){
                cardView2Email.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.not_valid))
            }
            return emailValid
        }
        fun isPhoneValid(): Boolean {
            if(!phoneValid){
                cardView2Phone.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.not_valid))
            }
            return phoneValid
        }
    }
    companion object {
        val allInstances = mutableListOf<PhoneItemViewHolder>()
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