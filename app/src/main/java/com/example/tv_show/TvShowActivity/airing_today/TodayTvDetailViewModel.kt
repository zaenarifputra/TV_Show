package com.example.tv_show.TvShowActivity.airing_today

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tv_show.BuildConfig.API_KEY
import com.example.tv_show.network.ApiConfig
import com.example.tv_show.network.details.TvDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodayTvDetailViewModel : ViewModel() {
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _TvDetailTodayData = MutableLiveData<TvDetailsResponse>()
    val TvDetailTodayData: LiveData<TvDetailsResponse> = _TvDetailTodayData

    fun getTvDetailsById(tvId: String){
        ApiConfig.getApiService().getTvDetailsById(tvId, API_KEY).enqueue(
            object : Callback<TvDetailsResponse> {
                override fun onResponse
                            (call: Call<TvDetailsResponse>,
                             response: Response<TvDetailsResponse>,
                ) {
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            val data = responseBody
                            _TvDetailTodayData.postValue(data)
                        }
                    }else{
                        Log.e(TAG, "onResponseError : ${response.message()}")
                        _errorMessage.postValue("Error displaying list today tv")
                    }
                }

                override fun onFailure(call: Call<TvDetailsResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure ${t.message}")
                    Log.e(TAG, Log.getStackTraceString(t))
                    _errorMessage.postValue(t.message)
                }

            }
        )
    }
    companion object {
        private val TAG = TodayTvDetailViewModel::class.simpleName
    }
}