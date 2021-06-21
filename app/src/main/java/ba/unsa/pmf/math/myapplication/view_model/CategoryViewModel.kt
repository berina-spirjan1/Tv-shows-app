package ba.unsa.pmf.math.myapplication.view_model

import androidx.lifecycle.*
import ba.unsa.pmf.math.myapplication.models.MovieResponse
import ba.unsa.pmf.math.myapplication.repository.CategoryRespository
import ba.unsa.pmf.math.myapplication.util.Asserts
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
public class CategoryViewModel @Inject constructor(val movieCategoryRepository: CategoryRespository) : ViewModel() {
    var forSearch = false
    val movieShow: MutableLiveData<String> = MutableLiveData("tv")
    val queryForSeach: MutableLiveData<String> = MutableLiveData("")

    fun getTopRatedCategory(category: String) = movieCategoryRepository.getTopRatedCategory(category)
    fun searchTopRatedCategory(query: String) = movieCategoryRepository.searchTopRatedCategory(movieShow.value ?: "tv", query)



    fun fetchCategory(category: String, search: String): LiveData<Asserts<MovieResponse>> {
        return if(search.length <= 2)
            getTopRatedCategory(category)
        else searchTopRatedCategory(search)
    }

    private val query = MediatorLiveData<Pair<String?, String?>>().apply {
                addSource(movieShow) {
                    value = Pair(it, queryForSeach.value)}
                addSource(queryForSeach) {
                    value = Pair(movieShow.value, it)}
    }
    var readAllData: LiveData<Asserts<MovieResponse>> =
    Transformations.switchMap(query) { pair ->
        val movieShow = pair.first
        var search = pair.second
        if (movieShow != null && search != null) {
            fetchCategory(movieShow, search)}
        else null
    }
}