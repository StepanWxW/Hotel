package com.wxw.hotel.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityOrderBinding


class OrderActivity : AppCompatActivity() {

    private lateinit var viewModel: OrderViewModel

    private lateinit var binding : ActivityOrderBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        val intRandom: Int? = viewModel.intRandomLiveData.value

        binding.textNumberOrder.text = "текс + $intRandom"

        val backButton = findViewById<View>(R.id.backButtonOrder)
        backButton.setOnClickListener {
            finish()
        }
    }
}