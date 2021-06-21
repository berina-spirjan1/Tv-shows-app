package ba.unsa.pmf.math.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import ba.unsa.pmf.math.myapplication.retrofit.DataClient.API_KEY
import ba.unsa.pmf.math.myapplication.retrofit.GetDataService
import ba.unsa.pmf.math.myapplication.util.SourceAssert
import ba.unsa.pmf.math.myapplication.util.Asserts
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CategoryRespository @Inject constructor(
    val moviesApi: GetDataService
) : SourceAssert() {

    private fun <T> getDataWithRemote(
        networkCall: suspend () -> Asserts<T>
    ): LiveData<Asserts<T>> = liveData(Dispatchers.IO) {
        emit(Asserts.loading())
        val asserts = networkCall.invoke()
        if (asserts.status == Asserts.Status.SUCCESS)
            emit(asserts)
        else if (asserts.status == Asserts.Status.ERROR) {
            emit(Asserts.error(asserts.message!!))
        }
    }

    fun getTopRatedCategory(category: String) = getDataWithRemote {
        getResult { moviesApi.getTopRatedCategory(category, API_KEY) }
    }

    fun searchTopRatedCategory(category: String, query: String) = getDataWithRemote {
        getResult {
            moviesApi.searchTopRatedCategory(category, API_KEY, query)
        }
    }
}