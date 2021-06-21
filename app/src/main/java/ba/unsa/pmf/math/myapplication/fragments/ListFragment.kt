package ba.unsa.pmf.math.myapplication.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.unsa.pmf.math.myapplication.R
import ba.unsa.pmf.math.myapplication.databinding.FragmentMainBinding
import ba.unsa.pmf.math.myapplication.models.Movie
import ba.unsa.pmf.math.myapplication.view_model.CategoryViewModel
import ba.unsa.pmf.math.myapplication.adapter.RecyclerAdapter
import ba.unsa.pmf.math.myapplication.util.Asserts
import ba.unsa.pmf.math.myapplication.util.onTextChangeWaitListener
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class ListFragment : Fragment(), RecyclerAdapter.OnMovieListClick {
    private var temp_binding: FragmentMainBinding? = null
    private val binding get() = temp_binding!!
    private val mainFragmentViewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        temp_binding = FragmentMainBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.search_menu)

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                mainFragmentViewModel.forSearch = false
                mainFragmentViewModel.queryForSeach.value = ""
                binding.recyclerView.scrollToPosition(0)
                return true
        }
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                mainFragmentViewModel.forSearch = true
                return true
            }
        })

        val viewSearch = searchItem.actionView as SearchView

        if (mainFragmentViewModel.forSearch) {
            searchItem.expandActionView()
            viewSearch.setQuery(mainFragmentViewModel.queryForSeach.value, false)
            viewSearch.clearFocus()
        }
        viewSearch.onTextChangeWaitListener()
            .debounce(500)
            .onEach { search ->
                if(isVisible)
                    mainFragmentViewModel.queryForSeach.value = search
            }
            .launchIn(lifecycleScope)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        NavigationUI.setupWithNavController(binding.toolbarFragmentMain, findNavController())
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarFragmentMain)

        binding.moviesTvShows.addOnButtonCheckedListener { group, checkedId, isChecked ->
            mainFragmentViewModel.movieShow.value = group.findViewById<MaterialButton>(group.checkedButtonId).tag.toString()
        }

        val adapterRecycler = RecyclerAdapter(this).apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }

        mainFragmentViewModel.readAllData.observe(viewLifecycleOwner) { asserts ->

            asserts?.let {
                when (it.status) {
                    Asserts.Status.SUCCESS -> {
                        val movies = asserts.data?.movies?: emptyList()
                        adapterRecycler.submitList(movies.take(10))
                        binding.recyclerView.apply {
                            setAdapter(adapterRecycler)
                            layoutManager = LinearLayoutManager(requireContext())
                        }
                    }
                }
            }
        }
    }
    override fun onListItemClicked(movie: Movie) {
        findNavController().navigate(
                ListFragmentDirections.actionListFragmentToSingleItemCategory(movie)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        temp_binding = null
    }
}