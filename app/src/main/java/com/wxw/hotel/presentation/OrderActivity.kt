package com.wxw.hotel.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityOrderBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderActivity : AppCompatActivity() {

    private val viewModel by viewModel<OrderViewModel>()
    private lateinit var binding: ActivityOrderBinding

    @SuppressLint("StringFormatInvalid", "StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intRandom: Int? = viewModel.intRandomLiveData.value

        binding.textNumberOrder.text = getString(R.string.order_confirmation_message, intRandom)
        binding.backButtonOrder.setOnClickListener {
            finish()
        }
        binding.buttonSuper.setOnClickListener{
            navigateToHotelActivity()
        }
    }
    private fun navigateToHotelActivity() {
        val intent = Intent(this, HotelActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}