package com.example.mvp_learning.view

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_learning.R
import com.example.mvp_learning.model.Item
import kotlinx.android.synthetic.main.item_movie_list.view.*

class MainAdapter(private val list: List<Item>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflaterView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)

        return MainViewHolder(inflaterView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])

    }

    inner class MainViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(item: Item) {
            view.apply {
                Glide.with(this).load(item.image).error(R.drawable.ic_img_empty)
                    .into(iv_movie_image)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { // HTML 태그 제거
                    tv_title.text = Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY).toString()
                }

                tv_director.text = item.director
                tv_pubdate.text = item.pubDate
                tv_user_rating.text = item.userRating
            }


        }

    }

}

