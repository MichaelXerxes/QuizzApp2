package com.example.quizzapp2

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizzapp2.MoreQuestions.newCategoryQuestions

class MainActivity : AppCompatActivity() {
    private var btnStart:Button?=null
    private var isClicked:Boolean=false
    private var edName:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edName= findViewById(R.id.et_name)
        btnStart=findViewById(R.id.buttonStart)

        btnStart?.setOnClickListener {
            showMenu()

        }

    }
    private fun showMenu(){
        val menuDialong=Dialog(this)
        var number:Int=0
        menuDialong.setContentView(R.layout.question_menu)

        val flagButton:Button=menuDialong.findViewById(R.id.button_flags)
        val mathButton:Button=menuDialong.findViewById(R.id.button_maths)
        val carsButton:Button=menuDialong.findViewById(R.id.button_cars)
        val movieButton:Button=menuDialong.findViewById(R.id.button_movies)
        val historyButton:Button=menuDialong.findViewById(R.id.button_history)

        flagButton.setOnClickListener {
            isClicked=true
            number=1
            menuDialong.dismiss()
            startIntenty(number)
        }
        mathButton.setOnClickListener {
            isClicked=true
            number=2
            menuDialong.dismiss()
            startIntenty(number)
        }
        carsButton.setOnClickListener {
            isClicked=true
            number=3
            menuDialong.dismiss()
            startIntenty(number)
        }
        movieButton.setOnClickListener {
            isClicked=true
            number=4
            menuDialong.dismiss()
            startIntenty(number)
        }
        historyButton.setOnClickListener {
            isClicked=true
            number=5
            menuDialong.dismiss()
            startIntenty(number)
        }
        menuDialong.show()
    }

    private fun startIntenty(number:Int){
        if(isClicked) {
            if (edName!!.text.isEmpty()) {
                Toast.makeText(this, "Please your Enter Name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, edName!!.text.toString())
                intent.putExtra("Question set Number",number)
                startActivity(intent)
                finish()
            }
        }
    }
}