package com.example.mvp_learning.repository

import com.example.mvp_learning.model.NaverMovie

interface MainRepository {
    fun searchMovies(
        query: String,
        success: (NaverMovie) -> Unit,
        failed: (Throwable) -> Unit
    )
}