package com.example.basicuitesting.ui.movie

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
        button_open_camera.setOnClickListener {
            dispatchCameraIntent()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "onActivityResult: RESULT OK")
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    Log.d(TAG, "onActivityResult: testing01 called")
                    data?.extras.let { extras ->
                        if (extras == null || !extras.containsKey(KEY_IMAGE_DATA)) {
                            Log.d(TAG, "onActivityResult: testing01 called didint path")
                            return
                        }
                        Log.d(TAG, "onActivityResult: testing01 called path")

                        val imageBitmap = extras[KEY_IMAGE_DATA] as Bitmap?
                        image.setImageBitmap(imageBitmap)
                    }
                }
            }
        }
    }
    private fun dispatchCameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }
}