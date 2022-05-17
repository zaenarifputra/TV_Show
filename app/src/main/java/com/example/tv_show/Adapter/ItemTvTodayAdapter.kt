package com.example.tv_show.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tv_show.BuildConfig
import com.example.tv_show.R
import com.example.tv_show.databinding.ItemTodayTvBinding
import com.example.tv_show.network.response.ResultsItem

class ItemTvTodayAdapter(private val dataSet: List<ResultsItem>):
    RecyclerView.Adapter<ItemTvTodayAdapter.ViewHolder>(){

    var onItemClick:((ResultsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemIndicatorBinding = ItemTodayTvBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemIndicatorBinding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        val data = dataSet[position]
        viewHolder.bind(data)
    }

    override fun getItemCount() = dataSet.size

    inner class ViewHolder(private val binding: ItemTodayTvBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultsItem) {
            binding.apply {
                tvTitleMovie.text = data.name
                tvGenre.text = data.genreIds.toString()
                tvId.text = data.id.toString()
                tvOrigin.text = data.originCountry.toString()

                ivToday.load("${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"){
                    error(R.drawable.spyxfamily)
                }

            }
            binding.root.setOnClickListener {
                onItemClick?.invoke(dataSet[layoutPosition])
            }
        }
    }

}