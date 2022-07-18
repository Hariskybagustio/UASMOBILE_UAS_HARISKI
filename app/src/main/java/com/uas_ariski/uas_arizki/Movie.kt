package com.arizki_uas.uas_arizki

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(

    @SerializedName("title")
    val title : String?,

    @SerializedName ("overview")
    val overview :String ?,

    @SerializedName("poster_path")
    val poster_path : String?,

    @SerializedName("release_date")
    val release_date : String?,

    @SerializedName("original_language")
    val original_language : String?,

    @SerializedName("vote_average")
    val vote_average : String?


) : Parcelable {
    constructor() : this("","","","","","")

}