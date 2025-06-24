package com.example.junekotlinandroid1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentActivity : AppCompatActivity() {
    lateinit var edtFirstName : EditText
    lateinit var edtLastName : EditText
    lateinit var edtEnrollment : EditText
    lateinit var btnSubmit : Button
    val db=MyApp.database
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student)
        edtFirstName=findViewById(R.id.edtfirstname)
        edtLastName=findViewById(R.id.edtlastname)
        edtEnrollment=findViewById(R.id.edtenrollment)
        btnSubmit=findViewById(R.id.btnsubmit)

        btnSubmit.setOnClickListener {

            val studentInfoData = StudentInfoData(
                firstName = edtFirstName.text.toString(),
                lastName = edtLastName.text.toString(),
                enrollment = edtEnrollment.text.toString())

            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.IO) {
                    db.studentInfoDao().insert(studentInfoData)
                }
            }

            edtFirstName.text.clear()
            edtLastName.text.clear()
            edtEnrollment.text.clear()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}