package com.example.tv_show.network.details

import com.google.gson.annotations.SerializedName

data class Logo(

	@field:SerializedName("path")
	val path: String,

	@field:SerializedName("aspect_ratio")
	val aspectRatio: Double
)