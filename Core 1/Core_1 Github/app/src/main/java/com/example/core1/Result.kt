package com.example.core1

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class Result : ViewModel() {
    private var result = 0 // Create a result variable and initialize it to 0
    private var dice = 0 // Create a dice variable and initialize it to 0
    private var setvalue = true // Create a setvalue variable and initialize it to true
    init {
        Random(1)
    }
    fun rollDice() {
        dice = (1..6).random()
        setvalue = false
    }
    fun add() {
        result += dice
        setvalue = true // Set the setvalue to true after adding the dice number to the result
    }
    fun sub() {
        result -= dice
        if (result < 0) {
            result = 0
        }
        setvalue = true // Set the setvalue to true after subtracting the dice number from the result
    }
    fun reset() {
        result = 0
        setvalue = true // Set the setvalue to true after resetting the result
    }
    fun getResult(): Int {
        return result
    }
    fun setResult(value: Int) {
        result = value
    }
    fun getDice(): Int {
        return dice
    }
    fun getSetvalue(): Boolean {
        return setvalue
    }
    fun setDice(value: Int) {
        dice = value
    }
    fun setValue(value: Boolean) {
        setvalue = value
    }
}