package com.arizki_uas.uas_arizki.fragment.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.arizki_uas.uas_arizki.Movie
import com.arizki_uas.uas_arizki.R
import kotlinx.android.synthetic.main.activity_detail_movie.view.*
import kotlinx.android.synthetic.main.fragment_tv_show_fragmant.view.*
import kotlinx.android.synthetic.main.fragment_tv_show_fragmant.view.overview
import kotlinx.android.synthetic.main.fragment_tv_show_fragmant.view.release_date
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_item.view.movie_poster
import kotlinx.android.synthetic.main.movie_item.view.movie_title


class MovieAdapter1(
    private val movies : List<Movie>
) : RecyclerView.Adapter<MovieAdapter1.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie){
            itemView.overview.text=movie.overview
            itemView.release_date.text=movie.release_date
            itemView.movie_title.text = movie.title
            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_tv_show_fragmant, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}


