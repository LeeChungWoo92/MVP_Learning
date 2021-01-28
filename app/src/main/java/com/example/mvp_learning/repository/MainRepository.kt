package com.example.mvp_learning.repository

interface MainRepository {
    fun getMovieList(
        query: String
    )
}