package ba.unsa.pmf.math.myapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val movieId: Long,
    @SerializedName("title", alternate = ["name"])
    val title: String,
    @SerializedName("overview")
    val description: String,
    val vote_avg: Float,
    val releaseDate: String,
    val adult: Boolean,
    @SerializedName("poster_path")
    val poster: String
): Parcelable
