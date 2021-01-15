package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user__profile.*

class User_Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user__profile)
        init()
    }

    private fun init() {
        Glide.with(this)
            .load("https://i.pinimg.com/originals/89/9b/5a/899b5a79d5896d3a8c4938a5ad3970ee.jpg")
            .into(coverImageView)

        Glide.with(this)
            .load("https://cdn4.iconfinder.com/data/icons/people-avatar-1-2/512/7-512.png")
            .into(profileImageView)

        extractInfo()
    }

    private fun extractInfo() {
        val name = intent.extras?.getString("name", "")
        val lastName = intent.extras?.getString("last_name", "")
        val age = intent.extras?.getInt("age", 0)
        val color = intent.extras?.getString("color", "")
        val hobby = intent.extras?.getString("hobby", "")
        val sport = intent.extras?.getString("sport", "")

        nameTextView.text = name
        lastNameTextView.text = lastName
        ageTextView.text = age.toString()
        colorTextView.text = color
        hobbyTextView.text = hobby
        sportTextView.text = sport
    }


}