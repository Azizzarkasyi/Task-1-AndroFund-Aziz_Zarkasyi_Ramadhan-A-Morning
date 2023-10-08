package com.example.coba_git

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class register : AppCompatActivity() {
    private lateinit var username :EditText
    private lateinit var password :EditText
    private lateinit var con_password :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username = findViewById(R.id.username_register)
        password = findViewById(R.id.password_register)
        con_password = findViewById(R.id.confirm_password)

        val btn : Button = findViewById(R.id.button_register)
        btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("username",username.text.toString())
            bundle.putString("password",password.text.toString())
            bundle.putString("confirm password",con_password.text.toString())
            val  intent = Intent(this, login::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}