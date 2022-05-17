package com.example.tv_show.network.details

import com.google.gson.annotations.SerializedName

data class ProductionCountriesItem(

	@field:SerializedName("iso_3166_1")
	val iso31661: String,

	@field:SerializedName("name")
	val name: String
)