package com.wxw.hotel.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wxw.hotel.databinding.ActivityRoomsBinding
import com.wxw.hotel.presentation.adapter.RoomAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomsActivity : AppCompatActivity() {
    private val viewModel: RoomsViewModel by viewModel()

    private lateinit var binding : ActivityRoomsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewRooms = binding.recyclerViewRooms

        viewModel.roomLiveData.observe(this){
            val adapterRooms = RoomAdapter(it)
            recyclerViewRooms.adapter = adapterRooms
        }

        binding.backButtonRooms.setOnClickListener {
            finish()
        }
    }
}