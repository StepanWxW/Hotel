package com.wxw.hotel.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.wxw.hotel.R
import com.wxw.hotel.databinding.ActivityBookingBinding
import com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate.DelegateClickListener
import com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate.DelegateAdapterBooking
import com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate.PhoneItemDelegate
import com.wxw.hotel.presentation.adapter.delegateAdapter.itemDelegate.TouristDelegate
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.AddTouristItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.InfoBookingItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.InfoPriceItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.PhoneItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.PriceButtonItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.RatingItem
import com.wxw.hotel.presentation.adapter.delegateAdapter.model.TouristItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingActivity : AppCompatActivity(), DelegateClickListener {

    private lateinit var binding : ActivityBookingBinding
    private val items = mutableListOf<Any>()
    private lateinit var recyclerViewBooking: RecyclerView
    private lateinit var delegateAdapterBooking: DelegateAdapterBooking
    private var touristIndex  = 0
    private lateinit var touristNames: MutableList<String>
    private val viewModel: BookingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        touristNames = resources.getStringArray(R.array.tourist_names).toMutableList()
        recyclerViewBooking = binding.recyclerViewBooking
        delegateAdapterBooking = DelegateAdapterBooking(this)

        viewModel.bookingLiveData.observe(this) {
            items.add(RatingItem(it.hotelAddress, "${it.rating} ${it.ratingName}"))
            items.add(InfoBookingItem(
                departure = it.departure,
                arrivalCountry = it.arrivalCountry,
                tourDateStartStop = "${it.tourDateStart} - ${it.tourDateStop}",
                numberOfNights = "${it.numberOfNights} ночей",
                room = it.room,
                nutrition = it.nutrition
            ))
            items.add(PhoneItem())
            items.add(TouristItem(generateTouristDescription()))
            items.add(AddTouristItem())
            items.add(InfoPriceItem(it.tourPrice, it.fuelCharge, it.serviceCharge))
            items.add(PriceButtonItem(it.tourPrice+it.fuelCharge+it.serviceCharge))
            delegateAdapterBooking.items = items
            recyclerViewBooking.adapter = delegateAdapterBooking
        }

        binding.backButtonBooking.setOnClickListener {
            finish()
        }

    }
    override fun onAddTouristClick() {
        if (touristIndex < touristNames.size) {
            val insertionIndex = if (items.size >= 4) items.size - 3 else 0
            items.add(insertionIndex, TouristItem(generateTouristDescription()))
            delegateAdapterBooking.notifyItemInserted(insertionIndex)
        }
    }
    override fun onPayClick() {
        val touristCheck = TouristDelegate.checkAllTouristItemsValid()
        val phoneCheck = PhoneItemDelegate.checkAllTouristItemsValid()
        if(touristCheck && phoneCheck){
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }

    private fun generateTouristDescription(): String {
        val touristName = touristNames[touristIndex]
        touristIndex++
        return getString(R.string.tourist_description, touristName)
    }
}