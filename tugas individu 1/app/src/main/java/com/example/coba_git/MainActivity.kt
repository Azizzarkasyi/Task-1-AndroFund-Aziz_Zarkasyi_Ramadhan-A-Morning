package com.example.coba_git

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.coba_git.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var tampil :TextView
    private lateinit var btn :Button
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            replaceFragment(fragment1())



        }
        binding.button3.setOnClickListener {
            replaceFragment(fragment2())



        }


        tampil = findViewById(R.id.textViewmain)
        btn = findViewById(R.id.button)

        val username = intent.getParcelableExtra<user_login>("user_login")?.username
        val password = intent.getParcelableExtra<user_login>("user_login")?.password
        tampil.text = "username : $username | password : $password"

        btn.setOnClickListener{
            val  intent = Intent()
            intent.putExtra("riwayat","sudah pernah login")
            setResult(RESULT_OK,intent)
            finish()

        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTranssction = fragmentManager.beginTransaction()
        fragmentTranssction.replace(R.id.fragmentlayout,fragment)
        fragmentTranssction.commit()
    }
}