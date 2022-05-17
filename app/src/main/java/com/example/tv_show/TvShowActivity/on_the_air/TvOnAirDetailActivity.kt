package com.example.tv_show.TvShowActivity.on_the_air

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.tv_show.BuildConfig
import com.example.tv_show.R
import com.example.tv_show.databinding.ActivityTvOnAirDetailBinding
import com.example.tvshow.presentation.onair.OnAirTvActivity
import com.example.tvshow.presentation.onair.OnAirTvDetailsViewModel

class TvOnAirDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvOnAirDetailBinding
    private lateinit var viewModel: OnAirTvDetailsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvOnAirDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLeftOnAir.setOnClickListener {
            val intent = Intent(this, OnAirTvActivity::class.java)
            startActivity(intent)
        }
        initView()
    }

    private fun initView() {
        viewModel = ViewModelProvider(this)[OnAirTvDetailsViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_TV_ID, 0)
        viewModel.getTvDetailsById(id.toString())

        viewModel.detailsTvData.observe(this){data ->
            binding.apply {
                tvName.text = data.name
                tvTitle.text = data.name
                tvDesc.text = data.overview
                tvDate.text = data.firstAirDate
                tvCountry.text = data.originCountry.toString()

                ivDetail.load("${BuildConfig.BASE_IMAGE_URL}${data.posterPath}"){
                    error(R.drawable.spyxfamily)
                }
            }
        }
    }
    companion object{
        const val EXTRA_TV_ID = "extra_tv_id"
    }
}