package com.example.myapplication.ui.frament

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDeskripsiBinding
import com.example.myapplication.databinding.FragmentMakananBinding
import com.example.myapplication.response.ApiResponse


class DeskripsiFragment : Fragment() {


    private var _binding: FragmentDeskripsiBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentDeskripsiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiResponse = arguments?.getParcelable<ApiResponse>("RESPONSE")

        val rasKucingText = getString(R.string.ras_kucing_s, apiResponse?.jsonMemberClass ?: "Tidak diketahui")
        val akurasi = getString(R.string.akurasi_s, apiResponse?.confidence ?: "Tidak diketahui")


        // Set ke TextView
        binding.rasKucing.text = rasKucingText
        binding.akurasi.text = akurasi
        binding.deskripsi.text = apiResponse?.deskripsi ?: "Deskripsi tidak tersedia"


    }

}