package com.example.mvp_learning.network

import com.example.mvp_learning.Constants.CLIENT_ID
import com.example.mvp_learning.Constants.CLIENT_SECRET
import com.example.mvp_learning.model.NaverMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "X-Naver-Client-Id:$CLIENT_ID",
        "X-Naver-Client-Secret:$CLIENT_SECRET"
    )
    @GET("v1/search/movie.json")
    fun getMovieList(@Query("query") SearchKeyword: String): Call<NaverMovie>

}