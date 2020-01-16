package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        signoutBtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        Glide.with(this)
            .load("https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg")
            .into(mathPic)

        Glide.with(this)
            .load("https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg")
            .into(imageView5)

        Glide.with(this)
            .load("https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg")
            .into(imageView6)

        Glide.with(this)
            .load("https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg")
            .into(imageView7)

        Glide.with(this)
            .load("https://i.ytimg.com/vi/Kp2bYWRQylk/maxresdefault.jpg")
            .into(imageView8)

        infobtn.setOnClickListener {
            val intent = Intent(this, StatsAndInfoActivity::class.java)
            startActivity(intent)
        }

        mathPic.setOnClickListener {
            val intent = Intent(this, MathTestActivity::class.java)
            startActivity(intent)
        }
    }
}
