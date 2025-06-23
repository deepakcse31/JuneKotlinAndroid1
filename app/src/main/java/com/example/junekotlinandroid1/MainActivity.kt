package com.example.junekotlinandroid1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var name ="Android"
    val dev1="Feed"
    lateinit var dev2:String
    lateinit var edtName : TextView
    lateinit var btnSubmit : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        edtName=findViewById(R.id.tvname)
        name="Dev"
        dev2="Android1"
        edtName.text=name
        btnSubmit=findViewById(R.id.btnsubmit)
        btnSubmit.setOnClickListener {
            edtName.text="Change Text"
        }

       // dev1="feed"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}