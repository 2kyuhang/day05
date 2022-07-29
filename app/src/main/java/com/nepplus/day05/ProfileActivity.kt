package com.nepplus.day05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        saveBtn.setOnClickListener {
            val inputNick = changeNickEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("changedLick", inputNick)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }
}