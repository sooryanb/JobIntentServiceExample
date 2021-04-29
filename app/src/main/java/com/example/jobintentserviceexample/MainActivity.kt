package com.example.jobintentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text_input)
    }

    fun enqueueWork(v: View){
        val input = editText.text.toString()
        Log.d(TAG, "enqueueWork: $input")
        val serviceIntent = Intent(this, ExampleJobIntentService::class.java)
        serviceIntent.putExtra("inputExtra", input)

        val jobService = ExampleJobIntentService()
        jobService.enqueueWork(this, serviceIntent)

    }

}