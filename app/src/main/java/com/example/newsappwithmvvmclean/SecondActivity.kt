package com.example.newsappwithmvvmclean

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Get the URI of the image from the Intent
        val uriString = intent.getStringExtra("imageUri")

        if (uriString != null) {
            val uri = Uri.parse(uriString)

            // Load the Bitmap from the URI
            val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri))

            // Set the Bitmap to an ImageView (for example)
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageBitmap(bitmap)
        }
    }
}