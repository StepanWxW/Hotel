package com.wxw.hotel.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityRoomsBinding
import com.wxw.hotel.presentation.adapter.RoomAdapter

class RoomsActivity : AppCompatActivity() {
    private lateinit var viewModel: RoomsViewModel

    private lateinit var binding : ActivityRoomsBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RoomsViewModel::class.java]
        val recyclerViewRooms = binding.recyclerViewRooms

        viewModel.roomLiveData.observe(this){
            val adapterRooms = RoomAdapter(it, this)
            recyclerViewRooms.adapter = adapterRooms
        }

        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}