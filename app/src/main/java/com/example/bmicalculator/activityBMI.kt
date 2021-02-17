package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class activityBMI : AppCompatActivity() {
    var bmiNumber:Double=0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val personName=intent.getStringExtra("personName")
        val userName=findViewById<TextView>(R.id.userName)
        userName.setText(personName)

        if(savedInstanceState!=null) {
            bmiNumber = savedInstanceState.getDouble("bmiNumber")
            val status=findViewById<TextView>(R.id.status)
            status.setText(getStatus())
        }

        val btn= findViewById<Button>(R.id.calButton)

        btn.setOnClickListener{
            val weight=findViewById<TextView>(R.id.weight).text.toString()
            val height=findViewById<TextView>(R.id.height).text.toString()
            val status=findViewById<TextView>(R.id.status)

            bmiNumber=weight.toDouble()/(height.toDouble()*height.toDouble())

            status.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiNumber",bmiNumber)
    }


    fun getStatus():String{
        if(bmiNumber<18.5){
            return "UnderWeight"
        }
        else if(bmiNumber<=24.9)
        {
            return "Normal weight"
        }
        else if(bmiNumber<=29.9){
            return "Overweight"
        }
        else if(bmiNumber<=34.9){
            return "Obesity Class i"
        }
        else if(bmiNumber<=39.9){
            return "Obesity Class ii"
        }
        else{
            return "Obesity Class iii"
        }
    }
}