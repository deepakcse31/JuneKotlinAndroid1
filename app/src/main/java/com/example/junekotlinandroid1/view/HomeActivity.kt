package com.example.junekotlinandroid1.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.junekotlinandroid1.R
import com.example.junekotlinandroid1.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var edtSearch : EditText
    lateinit var tvsearch : TextView

    lateinit var homeViewModel: HomeViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        edtSearch=findViewById(R.id.edtsearch)
        tvsearch=findViewById(R.id.tvsearch)
        homeViewModel= ViewModelProvider(this).get(HomeViewModel::class.java)

        edtSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                homeViewModel.setSearch(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

        homeViewModel.search.observe(this){
            tvsearch.text=it
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}