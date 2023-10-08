package com.example.coba_git

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class login : AppCompatActivity() {
    private lateinit var  username : EditText
    private lateinit var  password : EditText
    private lateinit var  riwayat : TextView
    val  resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){
            val  data : Intent? = result.data
            val returnString:String? = data?.getStringExtra("riwayat")
            riwayat.text = returnString
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        riwayat = findViewById(R.id.riwayat)
        username =findViewById(R.id.username_login)
        password = findViewById(R.id.password_login)
        val bundle =  intent.extras
        if (bundle != null){
            username.setText(bundle.getString("username"))
            password.setText(bundle.getString("password"))
        }
        val btn : Button = findViewById(R.id.button_login)
        btn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user_login",user_login(username.text.toString(),password.text.toString()))
            resultLauncher.launch(intent)
        }
    }
}