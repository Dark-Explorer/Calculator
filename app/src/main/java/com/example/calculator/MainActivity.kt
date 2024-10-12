package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var firstNumber: Int = 0
    private var currentOperation: String = ""
    private var isNewNumber: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        resultTextView = findViewById(R.id.textView)

        // Number buttons
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("num$i", "id", packageName)
            findViewById<Button>(buttonId).setOnClickListener { numberClicked(i) }
        }

        // Operation buttons
        findViewById<Button>(R.id.plus).setOnClickListener { operationClicked("+") }
        findViewById<Button>(R.id.minus).setOnClickListener { operationClicked("-") }
        findViewById<Button>(R.id.times).setOnClickListener { operationClicked("*") }
        findViewById<Button>(R.id.divide).setOnClickListener { operationClicked("/") }

        // Other buttons
        findViewById<Button>(R.id.equal).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.CE).setOnClickListener { clearCurrentNumber() }
        findViewById<Button>(R.id.C).setOnClickListener { clearAll() }
        findViewById<Button>(R.id.BS).setOnClickListener { backspace() }
        findViewById<Button>(R.id.plusminus).setOnClickListener { toggleSign() }
    }

    private fun numberClicked(number: Int) {
        if (isNewNumber) {
            resultTextView.text = number.toString()
            isNewNumber = false
        } else {
            resultTextView.append(number.toString())
        }
    }

    private fun operationClicked(operation: String) {
        firstNumber = resultTextView.text.toString().toInt()
        currentOperation = operation
        isNewNumber = true
    }

    private fun calculateResult() {
        if (currentOperation.isNotEmpty()) {
            val secondNumber = resultTextView.text.toString().toInt()
            val result = when (currentOperation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> if (secondNumber != 0) firstNumber / secondNumber else 0
                else -> secondNumber
            }
            resultTextView.text = result.toString()
            currentOperation = ""
            isNewNumber = true
        }
    }

    private fun clearCurrentNumber() {
        resultTextView.text = "0"
        isNewNumber = true
    }

    private fun clearAll() {
        resultTextView.text = "0"
        firstNumber = 0
        currentOperation = ""
        isNewNumber = true
    }

    private fun backspace() {
        val currentText = resultTextView.text.toString()
        if (currentText.length > 1) {
            resultTextView.text = currentText.substring(0, currentText.length - 1)
        } else {
            resultTextView.text = "0"
            isNewNumber = true
        }
    }

    private fun toggleSign() {
        val currentValue = resultTextView.text.toString().toInt()
        resultTextView.text = (-currentValue).toString()
    }
}