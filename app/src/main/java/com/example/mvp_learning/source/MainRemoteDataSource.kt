package com.example.mvp_learning.source

import com.example.mvp_learning.model.NaverMovie

interface MainRemoteDataSource {
    fun searchMovies(
        query: String,
        success: (NaverMovie) -> Unit,
        failed: (Throwable) -> Unit
    )
}