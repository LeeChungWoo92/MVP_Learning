package com.example.mvp_learning.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_learning.R
import com.example.mvp_learning.model.Movie
import kotlinx.android.synthetic.main.item_movie_list.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val list: ArrayList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflaterView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)

        return MainViewHolder(inflaterView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(item: Movie) {
            Glide.with(view).load(item.image).into(view.iv_movie_image)
            view.tv_title.text = item.title
            view.tv_director.text = item.director
            view.tv_pubdate.text = item.pubDate
            view.tv_user_rating.text = item.userRating
        }

    }

}

