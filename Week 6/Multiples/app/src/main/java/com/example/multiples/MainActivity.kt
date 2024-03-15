package com.example.multiples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var numCorrectAnswer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val correctAnswerText = findViewById<TextView>(R.id.correctAnswer)
        correctAnswerText.text = "Correct Answers: $numCorrectAnswer"
        generateButton.setOnClickListener {
            generateQuestion()
        }
    }
    private fun generateQuestion() {
        val factors = Factors(Random.nextInt(1, 10), Random.nextInt(1, 10)) // Create a new Factors object with two random numbers
        val intent = Intent(this, SecondActivity::class.java) // Create a new intent with the context and the SecondActivity class
        intent.putExtra("factors", factors) // Add the Factors object to the intent
        startActivityForResult(intent, 101) // Start the SecondActivity and wait for a result with the request code 101
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MainActivity", "resultCode: $resultCode, requestCode: $requestCode") // Log the result code and request code
        if (requestCode == 101 && resultCode == RESULT_OK) { // Check if the request code is 101 and the result code is RESULT_OK
            if (data?.getBooleanExtra("isCorrect", false) == true) { // Check if the data contains a boolean extra with the key "isCorrect" and the value is true
                numCorrectAnswer++ // Increment the number of correct answers
            }
            // Update correct answer text
            val correctAnswerText = findViewById<TextView>(R.id.correctAnswer)
            correctAnswerText.text = "Correct answers: $numCorrectAnswer"
        }
    }
}