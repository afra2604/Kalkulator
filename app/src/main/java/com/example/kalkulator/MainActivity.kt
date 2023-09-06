package com.example.kalkulator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var textViewResult: TextView? = null
    var input = ""
    var num1 = 0.0
    var num2 = 0.0
    var operator = 0.toChar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.inp_Angka)
        textViewResult = findViewById<TextView>(R.id.txt_result)


    }

    fun onNumberClick(view: View) {
        val button = view as Button
        input += button.text.toString()
        editText!!.setText(input)
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        operator = button.text[0]
        num1 = input.toDouble()
        input = ""
    }

    fun onEqualsClick(view: View?) {
        num2 = input.toDouble()
        val result = performOperation(num1, num2, operator)
        textViewResult!!.text = result.toString()
    }

    private fun performOperation(num1: Double, num2: Double, operator: Char): Double {
        var result = 0.0
        when (operator) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            'X' -> result = num1 * num2
            ':' -> result = if (num2 != 0.0) {
                num1 / num2
            } else {

                Double.NaN
            }
        }
        return result
    }
}
