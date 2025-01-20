package com.example.myapplication.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ApiResponse(

	@field:SerializedName("care_details")
	val careDetails: CareDetails? = null,

	@field:SerializedName("confidence")
	val confidence: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("class")
	val jsonMemberClass: String? = null,

	@field:SerializedName("makanan")
	val makanan: Makanan? = null
) : Parcelable

@Parcelize
data class Makanan(

	@field:SerializedName("nutrisi")
	val nutrisi: String? = null
) : Parcelable

@Parcelize
data class CareDetails(

	@field:SerializedName("Perawatan Gigi")
	val perawatanGigi: List<String?>? = null,

	@field:SerializedName("Perawatan kuku")
	val perawatanKuku: List<String?>? = null,

	@field:SerializedName("Aktivitas")
	val aktivitas: List<String?>? = null,

	@field:SerializedName("Perawatan Bulu")
	val perawatanBulu: List<String?>? = null
) : Parcelable
