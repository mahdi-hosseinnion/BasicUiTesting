package com.example.basicuitesting.ui.movie

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.bumptech.glide.Glide
import com.example.basicuitesting.R
import com.example.basicuitesting.factory.MovieFragmentFactory
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_IMAGE_CAPTURE = 6742
private const val TAG = "MainActivity"
const val KEY_IMAGE_DATA = "data"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_launch_dialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        MaterialDialog(this)
            .show {
                input(
                    hint = "mahdi...",
                    waitForPositiveButton = true,
                    allowEmpty = false
                ) { dialog, name ->
                    setNameToTextView(name.toString())
                }
                title(R.string.text_enter_you_name)
                positiveButton(R.string.ok)
            }

    }

    private fun setNameToTextView(name: String) {
        text_name.text = name
    }
}