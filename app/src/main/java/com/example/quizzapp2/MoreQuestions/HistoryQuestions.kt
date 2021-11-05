package com.example.quizzapp2.MoreQuestions

import com.example.quizzapp2.Question

object HistoryQuestions {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val list=ArrayList<Question>()

        val que1=Question(1,"When and where was that?",0,"England 1917","Italy 1401",
            "Moscow 1614","Krakow 1232",2)
        list.add(que1)
        return list

    }
}