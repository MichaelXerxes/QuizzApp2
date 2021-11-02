package com.example.quizzapp2

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        // 1
        val que1=Question(
            1,"What country does this flag belong to?"
            ,R.drawable.burkinafaso,
            "Brasil","Nabiru","Burkina Faso",
            "Chile",3
        )
        val que2=Question(
            2,"What country does this flag belong to?",
            R.drawable.centralafricanrepublic,
            "HongKong", "Argentina","South Africa","Central Africa Republic",
            4
        )
        val que3=Question(
            3,"What country does this flag belong to?",
            R.drawable.curacao,"Cura Cao",
            "Mexico","Mongolia","Bali",
            1
        )
        val que4=Question(
            4,"What country does this flag belong to?",
            R.drawable.hongkong,"China","Hong Kong",
            "Chile","Azerbejdzan",2
        )
        val que5=Question(5,"What country does this flag belong to?",
            R.drawable.kygrystan,"Russia","Ireland",
            "Kygrystan","Latvia",3)
        val que6=Question(6,"What country does this flag belong to?",
            R.drawable.palestine,"Palestine","Nigeria","Zambia",
            "Bolivia",1)
        val que7=Question(7,"What country does this flag belong to?",
            R.drawable.sierraleone,"New Zeland","Norway","Sierra Leone",
            "Israel",3)
        val que8=Question(8,"What country does this flag belong to?",
            R.drawable.southafrica,"Zambia","South Africa","Jordan",
            "Egypt",2)
        val que9=Question(9,"What country does this flag belong to?",
            R.drawable.tokelau,"Sudan","Toke Lau","Sri Lanka",
            "Philippines",2)
        val que10=Question(10,"What country does this flag belong to?",
            R.drawable.trinidadandtobago,"Trinidad","China","Austria",
            "Vietnam",1)
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)



        return questionList
    }
}