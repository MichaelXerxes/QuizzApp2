package com.example.quizzapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var btnStart:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edName= findViewById<EditText>(R.id.et_name)
        btnStart=findViewById(R.id.buttonStart)

        btnStart?.setOnClickListener {
            if (edName.text.isEmpty()){
                Toast.makeText(this,"Please your Enter Name",Toast.LENGTH_SHORT).show()
            }else{
                val intent=Intent(this,QuizQuestionActivity::class.java)
                // send extra to next activity
                intent.putExtra(Constants.USER_NAME,edName.text.toString())

                startActivity(intent)
                finish()
            }
        }
    }
}