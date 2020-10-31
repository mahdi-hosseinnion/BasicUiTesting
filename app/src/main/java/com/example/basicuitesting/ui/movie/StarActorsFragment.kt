package com.example.basicuitesting.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.basicuitesting.R
import kotlinx.android.synthetic.main.fragment_star_actors.*

class StarActorsFragment : Fragment(R.layout.fragment_star_actors) {
    private lateinit var _StarActors: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getStringArrayList("star_actors")?.let {
                _StarActors = it
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStarActors()
    }

    private fun setStarActors() {
        star_actors_text.text = stringBuilderForStarActors(_StarActors)
    }

    companion object {
        fun stringBuilderForStarActors(actors: ArrayList<String>): String {
            val sb = StringBuilder()
            for (actor in actors) {
                sb.append(actor + "\n")
            }
            return sb.toString()
        }
    }
}