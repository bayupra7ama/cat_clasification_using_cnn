package com.example.myapplication.ui

import MakananFragment
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.MainMainBinding
import com.example.myapplication.response.ApiResponse
import com.example.myapplication.response.CareDetails
import com.example.myapplication.response.Makanan
import com.example.myapplication.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: MainMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val careDetails = intent.getParcelableExtra<CareDetails>("CARE_DETAILS")
        val foodDetails = intent.getParcelableExtra<Makanan>("FOOD_DETAILS")
        val hasil = intent.getParcelableExtra<ApiResponse>("RESPONSE")

        val imageUriString = intent.getStringExtra("CAT_IMAGE_URI")

        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            binding.ivCat.setImageURI(imageUri)
        }


       binding.ivBack.setOnClickListener {
           finish()
       }

        // Set up ViewPager dan TabLayout
        val viewPagerAdapter = ViewPagerAdapter(this, careDetails, foodDetails, hasil)
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Deskripsi"
                1 -> tab.text = "Perawatan"
                2 -> tab.text = "Makanan"
            }
        }.attach()
    }
}
