package com.arizki_uas.uas_arizki.fragment.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arizki_uas.uas_arizki.*
import kotlinx.android.synthetic.main.fragment_movie1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment1 : Fragment() {

    var movies: List<Movie>? = null
    private lateinit var MovieAdapter1: MovieAdapter1

    companion object {
        fun newInstance() = MovieFragment1()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movies_list2.layoutManager = LinearLayoutManager(activity)
        rv_movies_list2.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies_list2.adapter = MovieAdapter1(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies = response.body()!!.movies

                return callback(response.body()!!.movies)

            }
        })
    }
}