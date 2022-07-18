package com.arizki_uas.uas_arizki

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {


    @GET("/3/movie/popular?api_key=d26a1e56601a2fa9aeac4bb538354b8b")
    fun getMovieList(): Call<MovieResponse>
}

