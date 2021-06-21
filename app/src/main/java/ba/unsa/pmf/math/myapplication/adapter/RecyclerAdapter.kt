package ba.unsa.pmf.math.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ba.unsa.pmf.math.myapplication.databinding.SingleItemForCategoryBinding
import ba.unsa.pmf.math.myapplication.models.Movie
import ba.unsa.pmf.math.myapplication.util.loadMovieUrl

class RecyclerAdapter constructor(val listener: OnMovieListClick): ListAdapter<Movie, RecyclerAdapter.CategoryViewHolder>(DiffCallback()) {

    interface OnMovieListClick {
        fun onListItemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = SingleItemForCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bindViews(category)
    }

    inner class CategoryViewHolder(val binding: SingleItemForCategoryBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bindViews(movie: Movie) {
            binding.titleForCategorySingleItem.text = movie.title
            binding.descriptionForCategorySingleItem.text = movie.description
            binding.posterForDetail.loadMovieUrl(movie.poster)
            binding.root.setOnClickListener {
                listener.onListItemClicked(movie)
            }
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieId == newItem.movieId && oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }


}