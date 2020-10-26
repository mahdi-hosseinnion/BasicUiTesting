package com.example.basicuitesting.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.basicuitesting.R
import com.example.basicuitesting.data.Movie
import com.example.basicuitesting.data.source.MovieRemoteDataSource
import com.example.basicuitesting.data.source.MoviesDataSource
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private lateinit var _Movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let { id ->
                MovieRemoteDataSource.getMovie(id)?.let {
                    _Movie = it
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetail()

        movie_directiors.setOnClickListener {
            val directors = _Movie.directors
            val bundle = Bundle()
            bundle.putStringArrayList("directors", directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DirectorsFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }
        movie_star_actors.setOnClickListener {
            val directors = _Movie.star_actors
            val bundle = Bundle()
            bundle.putStringArrayList("star_actors", directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, StarActorsFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetail() {
        _Movie.let { nonNullMovie ->
            Glide.with(this)
                .load(nonNullMovie.image)
                .into(movie_image)
            movie_title.text = nonNullMovie.title
            movie_description.text = nonNullMovie.description
        }
    }
}