package com.example.quizzapp2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val tvName:TextView=findViewById(R.id.tv_winerName)
        val tvScore:TextView=findViewById(R.id.tv_finalscore)
        val btnFinish:Button=findViewById(R.id.btn_final)
        val mUserName=intent.getStringExtra(Constants.USER_NAME)
        val mCorrectAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val maxQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tvName.text=mUserName
        tvScore.text=("Your Score: $mCorrectAnswers/$maxQuestions")
        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }




    }
}