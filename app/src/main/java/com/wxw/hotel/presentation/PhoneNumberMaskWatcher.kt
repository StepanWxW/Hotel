package com.wxw.hotel.presentation
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class PhoneNumberMaskWatcher(private val editText: EditText) : TextWatcher {
    private var isFormatting: Boolean = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        if (isFormatting) {
            return
        }

        isFormatting = true

        // Удаляем все символы, кроме цифр
        val digits = s?.toString()?.replace("[^\\d]".toRegex(), "")

        if (digits.isNullOrEmpty()) {
            editText.text?.clear()
            isFormatting = false
            return
        }

        // Применяем маску +7 (***) ***-**-**
        val formattedNumber = StringBuilder()
        if (digits.length >= 1) {
            formattedNumber.append("+7")
        }

        if (digits.length >= 2) {
            formattedNumber.append(" (")
            formattedNumber.append(digits.substring(1, Math.min(4, digits.length)))
            if (digits.length >= 4) {
                formattedNumber.append(")")
            }
        }

        if (digits.length >= 5) {
            formattedNumber.append(" ")
            formattedNumber.append(digits.substring(4, Math.min(7, digits.length)))
            if (digits.length >= 7) {
                formattedNumber.append("-")
            }
        }

        if (digits.length >= 8) {
            formattedNumber.append(digits.substring(7, Math.min(9, digits.length)))
            if (digits.length >= 9) {
                formattedNumber.append("-")
            }
        }

        if (digits.length >= 10) {
            formattedNumber.append(digits.substring(9, Math.min(11, digits.length)))
        }

        editText.setText(formattedNumber)
        editText.setSelection(formattedNumber.length)
        isFormatting = false
    }
}