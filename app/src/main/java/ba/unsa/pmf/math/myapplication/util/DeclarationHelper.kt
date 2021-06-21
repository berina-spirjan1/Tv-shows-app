package ba.unsa.pmf.math.myapplication.util

import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import ba.unsa.pmf.math.myapplication.retrofit.DataClient
import coil.load
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

fun ImageView.loadMovieUrl(route: String?) {
    this.load(DataClient.POSTER_BASE_URL + (route ?: ""))
}

@ExperimentalCoroutinesApi
fun SearchView.onTextChangeWaitListener() = callbackFlow {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText != null && newText.isNotEmpty())
                trySend(newText)
            else trySend("")

            return true
        }
    })


    setOnCloseListener {
        trySend("")
        false
    }

    awaitClose { setOnQueryTextListener(null) }
}