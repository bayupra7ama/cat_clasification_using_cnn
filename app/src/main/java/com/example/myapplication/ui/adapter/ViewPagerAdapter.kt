package com.example.myapplication.ui.adapter

import MakananFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.response.ApiResponse
import com.example.myapplication.response.CareDetails
import com.example.myapplication.response.Makanan
import com.example.myapplication.ui.frament.DeskripsiFragment
import com.example.myapplication.ui.frament.PerawatanFragment

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val careDetails: CareDetails?,
    private val foodDetails: Makanan?,
    private val apiResponse: ApiResponse?
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Jumlah tab (Deskripsi, Perawatan, Makanan)
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeskripsiFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("RESPONSE", apiResponse)
                }
            }
            1 -> PerawatanFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("CARE_DETAILS", careDetails)
                }
            }
            2 -> MakananFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("FOOD_DETAILS", foodDetails)
                }
            }
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
