package com.example.tv_show

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tv_show.TvShowActivity.airing_today.TodayTvActivity
import com.example.tv_show.databinding.ActivityMainBinding
import com.example.tvshow.presentation.onair.OnAirTvActivity
import com.example.tvshow.presentation.populartv.PopularTvActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgbtnPopular.setOnClickListener {
            startActivity(Intent(this, PopularTvActivity::class.java))
        }
        binding.imgbtnOnAir.setOnClickListener {
            startActivity(Intent(this, OnAirTvActivity::class.java))
        }
        binding.imgbtnToday.setOnClickListener {
            startActivity(Intent(this, TodayTvActivity::class.java))
        }
    }
}