package com.example.tv_show.TvShowActivity.airing_today

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tv_show.Adapter.ItemTvTodayAdapter
import com.example.tv_show.MainActivity
import com.example.tv_show.databinding.ActivityTodayTvBinding

class TodayTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodayTvBinding
    private lateinit var viewModel: TodayTvViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodayTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()
        binding.btnLeft.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun initObserver() {
        viewModel = ViewModelProvider(this)[TodayTvViewModel::class.java]

        viewModel.getTodayTv()

        viewModel.errorMessage.observe(this){message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        viewModel.listTvData.observe(this) {listTvData ->
            val listTvAdapter = ItemTvTodayAdapter(listTvData)
            binding.rvTodayTv.adapter = listTvAdapter

            listTvAdapter.onItemClick = { resultsItem ->
                val intent = Intent(this, TvTodayDetailActivity::class.java)
                intent.putExtra(TvTodayDetailActivity.EXTRA_TV_ID, resultsItem.id)
                startActivity(intent)
            }
        }
    }
}