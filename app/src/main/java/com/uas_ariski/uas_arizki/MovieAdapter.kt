package com.arizki_uas.uas_arizki

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.view.*
import kotlinx.android.synthetic.main.activity_detail_movie.view.overview
import kotlinx.android.synthetic.main.fragment_tv_show_fragmant.view.*
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_item.view.movie_poster
import kotlinx.android.synthetic.main.movie_item.view.movie_title

class MovieAdapter(
    private val movies : List<Movie>, val listener: OnAdapterListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindMovie(movie : Movie){
            itemView.overview2.text=movie.overview
            itemView.vote_average.text=movie.vote_average
            itemView.movie_release_date.text=movie.release_date
            itemView.movie_title.text = movie.title
            Glide.with(itemView).load(IMAGE_BASE + movie.poster_path).into(itemView.movie_poster)
            Log.e("MovieAdapter","URL Image ==> $IMAGE_BASE${movie.poster_path}")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
        holder.itemView.setOnClickListener { listener.onClick(movies[position]) }
    }
    interface OnAdapterListener {
        fun onClick(result: Movie)
    }

}