package com.coding.twoactivityresultcallback

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var outputTxt : TextView

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if (result.resultCode == Activity.RESULT_OK){
                val intent = result.data
                outputTxt.text = intent?.getStringExtra("name")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputTxt = findViewById(R.id.outputTxt)
        val secondBtn = findViewById<Button>(R.id.secondBtn)
        secondBtn.setOnClickListener {
            val secondIntent = Intent(this,SecondActivity::class.java)
            startForResult.launch(secondIntent)
        }
    }
}