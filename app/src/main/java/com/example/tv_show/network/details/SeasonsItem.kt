package com.example.tv_show.network.details

import com.google.gson.annotations.SerializedName

data class SeasonsItem(

	@field:SerializedName("air_date")
	val airDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("episode_count")
	val episodeCount: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("season_number")
	val seasonNumber: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("networks")
	val networks: List<NetworksItem>,

	@field:SerializedName("poster_path")
	val posterPath: Any
)