package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicuitesting.R
import com.example.basicuitesting.data.Movie
import com.example.basicuitesting.data.source.MoviesDataSource
import com.example.basicuitesting.util.EspressoIdlingResource
import com.example.basicuitesting.util.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MovieListFragment
constructor(
    val moviesDataSource: MoviesDataSource
) : Fragment(R.layout.fragment_movie_list),
    MoviesListAdapter.Interaction {
    lateinit var listAdapter: MoviesListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getData()
    }

    private fun getData() {
        EspressoIdlingResource.increment()
        val job = GlobalScope.launch(IO) {
            delay(1000L)
        }
        job.invokeOnCompletion {
            GlobalScope.launch(Main) {
                listAdapter.submitList(moviesDataSource.getMovies())
                EspressoIdlingResource.decrement()
            }
        }
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            removeItemDecoration(TopSpacingItemDecoration(30))
            addItemDecoration(TopSpacingItemDecoration(30))
            listAdapter = MoviesListAdapter(this@MovieListFragment)
            adapter = listAdapter
        }
    }

    override fun onItemSelected(position: Int, item: Movie) {
        activity?.run {
            val bundle = Bundle()
            bundle.putInt("movie_id", item.id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .addToBackStack("MovieDetailFragment")
                .commit()
        }
    }

}