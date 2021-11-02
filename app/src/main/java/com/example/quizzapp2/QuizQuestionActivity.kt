package com.example.quizzapp2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.*

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener{
    private var mCurrentPorsition:Int=1
    private var mQuestonsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0

    private var mUserName:String?=null
    private var mCorrectAnswers:Int=0

    private var progresBar:ProgressBar?=null
    private var tvProgressTextV:TextView?=null
    private var tvquestion:TextView?=null
    private var image:ImageView?=null
    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        //String from Main Activity
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progresBar=findViewById(R.id.tv_progressbar)
        tvProgressTextV=findViewById(R.id.tv_progressTextView)
        tvquestion=findViewById(R.id.tv_question)
        image=findViewById(R.id.tv_image)
        optionOne=findViewById(R.id.tv_optionOne)
        optionTwo=findViewById(R.id.tv_optionTwo)
        optionThree=findViewById(R.id.tv_optionThree)
        optionFour=findViewById(R.id.tv_optionFour)
        btnSubmit=findViewById(R.id.btn_submit)

        mQuestonsList = Constants.getQuestions()
        setQuestion()

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestonsList!![mCurrentPorsition - 1]



        if(mCurrentPorsition==mQuestonsList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }

        image?.setImageResource(question.image)
        progresBar?.progress = mCurrentPorsition
        tvProgressTextV?.text = "$mCurrentPorsition" + "/" + progresBar?.max
        tvquestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border
            )
        }

    }

    private fun selectedOptionView(tv:TextView,selectedOptionNumber:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_background
        )
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.tv_optionOne ->{
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_optionTwo ->{
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_optionThree ->{
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_optionFour ->{
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition==0){
                    mCurrentPorsition++
                    when{
                        mCurrentPorsition<=mQuestonsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            //Toast.makeText(this,"You Made it to the End",Toast.LENGTH_SHORT).show()
                            val intent=Intent(this,ResultsActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestonsList?.size)
                            startActivity(intent)
                            //End this activity
                            finish()
                        }
                    }
                }else{
                    val question=mQuestonsList?.get(mCurrentPorsition-1)
                    // This is to check if the answer is wrong
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_default_option_border)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_default_option_border)

                    if(mCurrentPorsition==mQuestonsList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    //to avoid stay in current selected option
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1 -> {
                optionOne?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background=ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
        }
    }

}