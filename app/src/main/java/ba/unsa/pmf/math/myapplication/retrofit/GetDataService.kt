package ba.unsa.pmf.math.myapplication.retrofit

import ba.unsa.pmf.math.myapplication.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetDataService {

    @GET("{category}/top_rated")
    suspend fun getTopRatedCategory(@Path("category") category: String, @Query("api_key") key: String): Response<MovieResponse>

    @GET("search/{category}")
    suspend fun searchTopRatedCategory(@Path("category") category: String, @Query("api_key") key: String,
                                       @Query("query") search: String): Response<MovieResponse>

}
