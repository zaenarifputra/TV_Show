package com.example.tv_show.network.details

import com.google.gson.annotations.SerializedName

data class NetworksItem(

	@field:SerializedName("logo_path")
	val logoPath: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("origin_country")
	val originCountry: String,

	@field:SerializedName("logo")
	val logo: Logo
)