package com.example.tv_show.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tv_show.BuildConfig
import com.example.tv_show.R
import com.example.tv_show.databinding.ItemPopularTvBinding
import com.example.tv_show.network.response.ResultsItem

class ItemTvPopularAdapter(private val dataSet: List<ResultsItem>):
    RecyclerView.Adapter<ItemTvPopularAdapter.ViewHolder>(){

    var onItemClick:((ResultsItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemIndicatorBinding = ItemPopularTvBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemIndicatorBinding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        val data = dataSet[position]
        viewHolder.bind(data)
    }

    override fun getItemCount() = dataSet.size

    inner class ViewHolder(private val binding: ItemPopularTvBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultsItem) {
            binding.apply {
                tvName.text = data.name
                tvDescPopular.text = data.overview
                tvPopular.text = data.id.toString()
                tvTanggal.text = data.firstAirDate

                ivPopular.load("${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"){
                    error(R.drawable.img_onboarding1)
                }

            }
            binding.root.setOnClickListener {
                onItemClick?.invoke(dataSet[layoutPosition])
            }
        }
    }

}