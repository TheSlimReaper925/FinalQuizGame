package com.example.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_stats_and_info.*

class StatsAndInfoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats_and_info)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("userInfo")

        addUserInfoChangeListener()

        goInfoBtn.setOnClickListener {
            val intent = Intent(this, UserInfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun addUserInfoChangeListener() {
            database.child(auth.currentUser?.uid!!)
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {

                    }

                    override fun onDataChange(snap: DataSnapshot) {
                        val userInfo: UserInfo = snap.getValue(UserInfo::class.java) ?: return

                        nametext.text = userInfo.name
                        lastNameText.text = userInfo.lastname
                        nicknameText.text = userInfo.nickname
                        genderText.text = userInfo.gender


                    }

                })
    }
}
