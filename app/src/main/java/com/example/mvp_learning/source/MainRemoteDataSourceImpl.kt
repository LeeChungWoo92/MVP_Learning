package com.example.mvp_learning.source

import com.example.mvp_learning.model.NaverMovie
import com.example.mvp_learning.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRemoteDataSourceImpl : MainRemoteDataSource {
    override fun searchMovies(
        query: String,
        success: (NaverMovie) -> Unit,
        failed: (Throwable) -> Unit
    ) {

        RetrofitClient.create().getMovieList(query)
            .enqueue(object : Callback<NaverMovie> {
                override fun onFailure(call: Call<NaverMovie>, t: Throwable) {
                    failed(t)
                }

                override fun onResponse(call: Call<NaverMovie>, response: Response<NaverMovie>) {


                    if (response.isSuccessful) {
                        success(response.body()!!)

                        // list.clear()
                        // list!!.addAll((data.items))
                        //Log.d(TAG, "list : ${list.size}")

                        // mainAdapter = MainAdapter((list))
                        // mainAdapter.notifyDataSetChanged()

                        // rv_movie_list.adapter = mainAdapter


                    }

                }

            })

    }
}