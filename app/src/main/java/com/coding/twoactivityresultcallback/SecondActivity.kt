package com.coding.twoactivityresultcallback

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val edName = findViewById<EditText>(R.id.edName)
        val backBtn = findViewById<Button>(R.id.backBtn)


        backBtn.setOnClickListener {
            if (edName.text.toString().trim().isNotEmpty()){
                val resultBackIntent  = Intent()
                resultBackIntent.putExtra("name",edName.text.toString().trim())
                setResult(Activity.RESULT_OK,resultBackIntent)
                finish()

            }else{
                Toast.makeText(this,"Required",Toast.LENGTH_LONG).show()
            }
        }
    }
}