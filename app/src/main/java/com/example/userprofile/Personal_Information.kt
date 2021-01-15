package com.example.userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_personal__information.*

class Personal_Information : AppCompatActivity() {

    private val colorRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal__information)
        init()
    }

    private fun init() {
        nextPageImageButton.setOnClickListener {
            personalInformation()
        }
    }

    private fun personalInformation() {
        val name = nameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val age = ageEditText.text.toString().toInt()
        val color = colorEditText.text.toString()
        val hobby = hobbyEditText.text.toString()
        val sport = sportEditText.text.toString()

        if (name.isNotEmpty() && lastName.isNotEmpty() && age.toString().isNotEmpty() &&
            color.isNotEmpty() && hobby.toString().isNotEmpty()
        ) {
            nextPageImageButton.setOnClickListener {
                val intent = Intent(this, User_Profile::class.java)
                intent.putExtra("name", name)
                intent.putExtra("last_name", lastName)
                intent.putExtra("age", age)
                intent.putExtra("color", color)
                intent.putExtra("hobby", hobby)
                intent.putExtra("sport", sport)
                startActivityForResult(intent, colorRequestCode)
            }

        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }
}