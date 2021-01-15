package com.example.userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        logInButton.setOnClickListener {
            logIn()
        }
    }

    private fun logIn() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (email.matches(emailPattern.toRegex())) {
                logInButton.setOnClickListener {
                    val intent = Intent(this, Personal_Information::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Email is invalid.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }
}