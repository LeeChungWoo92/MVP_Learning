package com.example.mvp_learning.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val API_SERVER_URI: String = "https://openapi.naver.com/"

    fun create() : ApiService{

        return Retrofit.Builder()
            .baseUrl(API_SERVER_URI)
            .addConverterFactory(GsonConverterFactory.create()) // Json형식의 파일을 POJO class 형식으로 자동변환
            .build()
            .create(ApiService::class.java)


    }

}