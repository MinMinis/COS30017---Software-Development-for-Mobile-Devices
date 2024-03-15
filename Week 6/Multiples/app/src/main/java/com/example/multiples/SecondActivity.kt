package com.example.multiples

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Retrieve the factors object using getParcelableExtra
        val factors = intent.getParcelableExtra<Factors>("factors")
        val result = factors?.factor1?.times(factors.factor2) ?: 0
        // Display question and answer choices
        val questionText = findViewById<TextView>(R.id.question)
        questionText.text = "What is ${factors?.factor1} * ${factors?.factor2}?"
        val answer = findViewById<TextView>(R.id.answer)
        answer.text = result.toString()
        // Correct and Incorrect button functionality
        val correct = findViewById<Button>(R.id.correct)
        correct.setOnClickListener {
            sendAnswerResult(true)
        }
        val incorrect = findViewById<Button>(R.id.incorrect)
        incorrect.setOnClickListener {
            sendAnswerResult(false)
        }

    }
    private fun sendAnswerResult (isCorrect: Boolean) {
        val intent = Intent()
        intent.putExtra("isCorrect", isCorrect)
        setResult(RESULT_OK, intent)
        finish()
    }
}