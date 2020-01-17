package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_math_test.*
import kotlinx.android.synthetic.main.activity_stats_and_info.*
import kotlinx.android.synthetic.main.activity_user_info.*

class MathTestActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_test)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("userInfo")

        val radioGroups = arrayOf(
            radioGroupOne,
            radioGroupTwo,
            radioGroupThree,
            radioGroupFour,
            radioGroupFive
        )

        submitBtn.setOnClickListener {
            var score = 0
            for (radioGroup in radioGroups) {
                val radio: RadioButton = findViewById(radioGroup.checkedRadioButtonId)


                when (radio.text) {
                    "b - a" -> score += 2
                    "75" -> score += 2
                    "64000 სმ^2" -> score += 2
                    "4" -> score += 2
                    "-3" -> score += 2
                }
            }

            scoreValue.text = "ქულა: 10/" + score.toString()
            submitBtn.isClickable = false

        }

    }
}