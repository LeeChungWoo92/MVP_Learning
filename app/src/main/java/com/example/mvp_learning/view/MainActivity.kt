package com.example.mvp_learning.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_learning.R
import com.example.mvp_learning.model.Item
import com.example.mvp_learning.model.NaverMovie
import com.example.mvp_learning.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var list = ArrayList<Item>()
    var mainAdapter = MainAdapter((list))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_search.setOnClickListener {
            getMovieSearch()
        }

        edit_query.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    getMovieSearch()
                }
            }
            true
        }

    }

    //네이버 영화목록 조회
    private fun getMovieSearch() {
        closeKeyboard(edit_query)

        if (progress_bar.visibility != View.VISIBLE) {
            progress_bar.visibility = View.VISIBLE
        }
        progress_bar.show()


        RetrofitClient.create().getMovieList(edit_query.text.toString())
            .enqueue(object : Callback<NaverMovie> {
                override fun onFailure(call: Call<NaverMovie>, t: Throwable) {

                    progress_bar.hide()
                    Log.d(TAG, "실패로그: ${t.message.toString()}")
                }

                override fun onResponse(call: Call<NaverMovie>, response: Response<NaverMovie>) {
                    progress_bar.hide()

                    Log.d(TAG, "성공로그 : ${response.body().toString()}")


                    if (response.isSuccessful) {
                        val data = response.body()!!
                        if (!data.items.isNullOrEmpty()) {


                            list.clear()
                            list!!.addAll((data.items))
                            Log.d(TAG, "list : ${list.size}")

                            mainAdapter = MainAdapter((list))
                            mainAdapter.notifyDataSetChanged()

                            rv_movie_list.adapter = mainAdapter
                        } else {

                            Toast.makeText(this@MainActivity, "검색결과가 없습니다.", Toast.LENGTH_SHORT)
                                .show()
                        }


                    } else {


                    }

                }

            })
    }

    //키보드 내리기
    private fun closeKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}