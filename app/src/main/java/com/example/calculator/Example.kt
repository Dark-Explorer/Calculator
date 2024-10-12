//package com.example.calculator
//
//import android.graphics.Color
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity(), View.OnClickListener {
//
//    lateinit var textReuslt: TextView
//
//    var state: Int = 1
//    var op: Int = 0
//    var op1: Int = 0
//    var op2: Int = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textReuslt = findViewById(R.id.text_result)
//
//        findViewById<Button>(R.id.btn0).setOnClickListener(this)
//        findViewById<Button>(R.id.btn1).setOnClickListener(this)
//        findViewById<Button>(R.id.btn2).setOnClickListener(this)
//        findViewById<Button>(R.id.btn3).setOnClickListener(this)
//        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
//        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
//    }
//
//    override fun onClick(p0: View?) {
//        val id = p0?.id
//        if (id == R.id.btn0) {
//            addDigit(0)
//        } else if (id == R.id.btn1) {
//            addDigit(1)
//        } else if (id == R.id.btn2) {
//            addDigit(2)
//        } else if (id == R.id.btn3) {
//            addDigit(3)
//        } else if (id == R.id.btnAdd) {
//            op = 1
//            state = 2
//        } else if (id == R.id.btnEqual) {
//            var result = 0
//            if (op == 1) {
//                result = op1 + op2
//            }
//            textReuslt.text = "$result"
//            state = 1
//            op1 = 0
//            op2 = 0
//            op = 0
//        }
//
//    }
//
//    fun addDigit(c: Int) {
//        if (state == 1) {
//            op1 = op1 * 10 + c
//            textReuslt.text = "$op1"
//        } else {
//            op2 = op2 * 10 + c
//            textReuslt.text = "$op2"
//        }
//    }
//}