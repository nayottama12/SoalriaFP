package com.example.soalria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //hide tittle bar
        getSupportActionBar()?.hide()

        val welcomeLogo: ImageView = findViewById(R.id.imageViewWelcome)

        // Tidak ada animasi pada welcomeLogo

        // Set visibility menjadi terlihat tanpa animasi
        welcomeLogo.visibility = View.VISIBLE

        // Handler untuk beralih ke LoginActivity setelah penundaan
        Handler().postDelayed({
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(intent)

            // Tutup WelcomeActivity agar tidak dapat kembali
            finish()
        }, 3000) // Waktu penundaan dalam milidetik (3000 milidetik = 2 detik)
    }
}