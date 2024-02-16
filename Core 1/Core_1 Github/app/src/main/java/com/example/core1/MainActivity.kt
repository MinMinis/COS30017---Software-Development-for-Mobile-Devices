package com.example.core1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var result : Result // Create a Result object
    private lateinit var diceImage: ImageView // Create a diceImage object
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view of the activity
        logLifecycleEvent("onCreate") // Log the onCreate event
        result = Result() // Initialize the Result object
        diceImage = findViewById(R.id.imageView) // Initialize the diceImage object
        val rollButton = findViewById<Button>(R.id.RollButton) // Create a rollButton object
        val addButton = findViewById<Button>(R.id.Add) // Create an addButton object
        val subButton = findViewById<Button>(R.id.Subtract) // Create a subButton object
        val resetButton = findViewById<Button>(R.id.Reset) // Create a resetButton object

        rollButton.setOnClickListener { // Set an OnClickListener for the rollButton
            result.rollDice() // Roll the dice
            updateUI() // Update the Image of the dice
            checkButtonState(addButton, subButton, rollButton) // Check the state of the buttons
        }
        addButton.setOnClickListener { // Set an OnClickListener for the addButton
            result.add() // Add dice number to the result
            updateAndCheckButtonState(addButton, subButton, rollButton) // Update the result and check the state of the buttons
        }
        subButton.setOnClickListener { // Set an OnClickListener for the subButton
            result.sub() // Subtract dice number from the result
            updateAndCheckButtonState(addButton, subButton, rollButton)
        }
        resetButton.setOnClickListener { // Set an OnClickListener for the resetButton
            result.reset() // Reset the result
            updateAndCheckButtonState(addButton, subButton, rollButton)
        }
        if (savedInstanceState != null) { // Check if the savedInstanceState is not null
            result.setResult(savedInstanceState.getInt("result")) // Set the result to the value from the savedInstanceState
            result.setDice(savedInstanceState.getInt("dice")) // Set the dice to the value from the savedInstanceState
            result.setValue(savedInstanceState.getBoolean("setvalue")) // Set the setvalue to the value from the savedInstanceState
        }
        updateUI() // Update the Image of the dice
        updateAndCheckButtonState(addButton, subButton, rollButton)
    }
    private fun updateAndCheckButtonState(addButton: Button, subButton: Button, rollButton: Button) {
        updateResult(findViewById(R.id.textView)) // Update the result
        checkButtonState(addButton, subButton, rollButton) // Check the state of the buttons
    }
    private fun updateResult(resultField : TextView) {
        resultField.text = result.getResult().toString() // Set the text of the resultField to the result
        Log.d("Result", "Result: ${result.getResult()}") // Log the result value
        when {
            result.getResult() == 20 -> resultField.setTextColor(getColor(R.color.green)) // Set color of text to green when result is 20
            result.getResult() < 19 -> resultField.setTextColor(getColor(R.color.black)) // Set color of text to black when result is less than 19
            result.getResult() > 20 -> resultField.setTextColor(getColor(R.color.red)) // Set color of text to red when result is greater than 20
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("result", result.getResult()) // Save the result to the savedInstanceState
        outState.putInt("dice", result.getDice()) // Save the dice to the savedInstanceState
        outState.putBoolean("setvalue", result.getSetvalue()) // Save the setvalue to the savedInstanceState
        logLifecycleEvent("onSaveInstanceState") // Log the onSaveInstanceState event
    }

    private fun updateUI() {
        val drawableResource = when (result.getDice()) { // Set the drawableResource to the dice image based on the dice value
            1 -> R.drawable.dice_six_faces_one
            2 -> R.drawable.dice_six_faces_two
            3 -> R.drawable.dice_six_faces_three
            4 -> R.drawable.dice_six_faces_four
            5 -> R.drawable.dice_six_faces_five
            6 -> R.drawable.dice_six_faces_six
            else -> R.drawable.dice_six_faces_zero
        }
        Log.d("Dice", "Dice: ${result.getDice()}") // Log the result value
        diceImage.setImageResource(drawableResource) // Set the Image of the dice to the drawableResource
    }
    private fun checkButtonState(addButton : Button, subButton : Button, rollButton: Button) {
        if (result.getSetvalue()) { // Check if the setvalue is true
            addButton.isEnabled = false
            subButton.isEnabled = false
            rollButton.isEnabled = true
        } else { // If the setvalue is false
            addButton.isEnabled = true
            subButton.isEnabled = true
            rollButton.isEnabled = false
        }
    }
    override fun onStart() { // Log the onStart event
        super.onStart()
        logLifecycleEvent("onStart")
    }
    override fun onResume() { // Log the onResume event
        super.onResume()
        logLifecycleEvent("onResume")
    }
    override fun onPause() { // Log the onPause event
        super.onPause()
        logLifecycleEvent("onPause")
    }
    override fun onStop() { // Log the onStop event
        super.onStop()
        logLifecycleEvent("onStop")
    }
    override fun onDestroy() { // Log the onDestroy event
        super.onDestroy()
        logLifecycleEvent("onDestroy")
    }
    private fun logLifecycleEvent(event: String) { // Log the lifecycle event
        Log.d("MainActivity", "Lifecycle Event: $event")
    }
}