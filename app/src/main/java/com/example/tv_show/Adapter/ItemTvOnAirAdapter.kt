package com.example.tv_show.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tv_show.BuildConfig
import com.example.tv_show.R
import com.example.tv_show.databinding.ItemTvOnairBinding
import com.example.tv_show.network.response.ResultsItem

class ItemTvOnAirAdapter(private val dataSet: List<ResultsItem>):
    RecyclerView.Adapter<ItemTvOnAirAdapter.ViewHolder>(){

    var onItemClick:((ResultsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemIndicatorBinding = ItemTvOnairBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemIndicatorBinding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        val data = dataSet[position]
        viewHolder.bind(data)
    }

    override fun getItemCount() = dataSet.size

    inner class ViewHolder(private val binding: ItemTvOnairBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultsItem) {
            binding.apply {
                tvTitleMovie.text = data.name
                tvGenre.text = data.genreIds.toString()
                tvId.text = data.voteAverage.toString()
                tvOrigin.text = data.originCountry.toString()

                ivTodayOnair.load("${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"){
                    error(R.drawable.spyxfamily)
                }

            }
            binding.root.setOnClickListener {
                onItemClick?.invoke(dataSet[layoutPosition])
            }
        }
    }
}