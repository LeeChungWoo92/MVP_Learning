package com.example.mvp_learning.presenter

import com.example.mvp_learning.model.NaverMovie

interface MainContract {

    interface View {
        fun showMoive(movies : List<NaverMovie>)
        fun showProgressbar()
        fun hideProgressbar()
        fun showToast()
        fun hideKeyboard()
    }

    interface Presenter {
        fun searchMovie(query: String)
    }
}