package com.example.quizzapp2.MoreQuestions

import com.example.quizzapp2.Question
import com.example.quizzapp2.R

object newCategoryQuestions {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val list=ArrayList<Question>()

        val que1=Question(1,"Ile to 2+2 ",
            R.drawable.burkinafaso,"6","8",
            "4","5",3)
        list.add(que1)
        val que2=Question(2,"Ile to 3+2 ",
            R.drawable.burkinafaso,"6","8",
            "4","5",4)
        list.add(que2)
        val que3=Question(3,"Ile to 5+5",
        0,"1","7","9","10",4)
        list.add(que3)
        return list

    }
}