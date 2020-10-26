package com.example.basicuitesting.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.basicuitesting.R
import kotlinx.android.synthetic.main.fragment_directors.*

class DirectorsFragment : Fragment(R.layout.fragment_directors) {
    private lateinit var _Directors: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getStringArrayList("directors")?.let {
                _Directors = it
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDirectors()
    }

    private fun setDirectors() {
        directors_text.text = stringBuilderForDirectors(_Directors)
    }

    companion object {
        fun stringBuilderForDirectors(directors: ArrayList<String>): String {
            val sb = StringBuilder()
            for (director in directors) {
                sb.append(director + "\n")
            }
            return sb.toString()
        }
    }
}