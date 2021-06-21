package ba.unsa.pmf.math.myapplication.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataClient {
    const val API_KEY="7a107d136d3681f2a328d0a76391cb45"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    private val clientHttp: OkHttpClient by lazy {
        val helper = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return@lazy OkHttpClient.Builder().addInterceptor(helper).build()
    }

    private val buildRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val serviceApiInterface: GetDataService by lazy {
        buildRetrofit.create(GetDataService::class.java)
    }
}