package com.nepplus.day05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_profile_image.*

class DetailProfileImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile_image)


//        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
//        photoView.setImageResource(R.drawable.image);

        photoView.setImageResource(R.drawable.ic_launcher_foreground)

    }
}