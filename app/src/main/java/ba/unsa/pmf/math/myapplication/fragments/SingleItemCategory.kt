package ba.unsa.pmf.math.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ba.unsa.pmf.math.myapplication.databinding.FragmentSingleItemCategoryBinding
import ba.unsa.pmf.math.myapplication.util.loadMovieUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleItemCategory : Fragment() {

    private val args: SingleItemCategoryArgs by navArgs()

    private var temp_binding: FragmentSingleItemCategoryBinding? = null
    private val binding get() = temp_binding!!


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        temp_binding = FragmentSingleItemCategoryBinding.inflate(inflater, container, false)
        getActivity()?.setTitle("Details");
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category=args.item
        binding.categoryTitle.text=category.title
        binding.posterForDetail.loadMovieUrl(category.poster)
        binding.categoryDescription.text = category.description
    }

    override fun onDestroyView() {
        temp_binding = null
        super.onDestroyView()
    }
}