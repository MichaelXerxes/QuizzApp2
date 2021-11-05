package com.example.quizzapp2.MoreQuestions

import com.example.quizzapp2.Question

object MoviesQuestions {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"
    fun getQuestions():ArrayList<Question>{
        val list=ArrayList<Question>()

        val que1=Question(1,"What movie it is?",0,"2012","I`m Legend",
            "Psy","Dune",4)
        list.add(que1)
        return list

    }
}