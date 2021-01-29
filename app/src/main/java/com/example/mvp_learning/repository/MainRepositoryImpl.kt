package com.example.mvp_learning.repository

import com.example.mvp_learning.model.NaverMovie
import com.example.mvp_learning.source.MainRemoteDataSourceImpl

class MainRepositoryImpl : MainRepository {

    private val mainRemoteDataSourceImpl = MainRemoteDataSourceImpl()

    override fun searchMovies(
        query: String,
        success: (NaverMovie) -> Unit,
        failed: (Throwable) -> Unit
    ) {
        mainRemoteDataSourceImpl.searchMovies(
            query,
            success,
            failed
        )
    }
}