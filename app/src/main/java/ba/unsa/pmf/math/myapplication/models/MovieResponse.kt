package ba.unsa.pmf.math.myapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("page")
    val page: Int,
    val totalResults: Int,
    @SerializedName("results")
    var movies: List<Movie>
): Parcelable