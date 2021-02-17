package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextPage= findViewById<Button>(R.id.nextPage)

        nextPage.setOnClickListener {

            val intent = Intent(this, activityBMI::class.java)

            val personName=findViewById<TextView>(R.id.name).text
            intent.putExtra("personName",personName.toString())

            startActivity(intent)
        }
    }
}