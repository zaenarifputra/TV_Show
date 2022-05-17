package com.example.tvshow.presentation.onair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tv_show.Adapter.ItemTvOnAirAdapter
import com.example.tv_show.MainActivity
import com.example.tv_show.TvShowActivity.on_the_air.TvOnAirDetailActivity
import com.example.tv_show.databinding.ActivityOnAirTvBinding

class OnAirTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnAirTvBinding
    private lateinit var viewModel: OnAirTvViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnAirTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()
        binding.btnLeft.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun initObserver() {
        viewModel = ViewModelProvider(this)[OnAirTvViewModel::class.java]

        viewModel.getOnAirTv()

        viewModel.errorMessage.observe(this){message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        viewModel.listTvData.observe(this) {listTvData ->
            val listTvAdapter = ItemTvOnAirAdapter(listTvData)
            binding.rvOnairTv.adapter = listTvAdapter

            listTvAdapter.onItemClick = { resultsItem ->
                val intent = Intent(this, TvOnAirDetailActivity::class.java)
                intent.putExtra(TvOnAirDetailActivity.EXTRA_TV_ID, resultsItem.id)
                startActivity(intent)
            }
        }
    }
    }
