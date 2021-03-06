package com.example.jobintentserviceexample

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.core.app.JobIntentService

class ExampleJobIntentService: JobIntentService() {

    fun enqueueWork(context: Context, work: Intent){
        enqueueWork(context, ExampleJobIntentService::class.java, 123, work)
    }

    val TAG = "ExampleJobIntentService"

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "onHandleWork")

        val input = intent.getStringExtra("inputExtra")
        for(i in 1..10){
            Log.d(TAG, "$input - $i")
            if(isStopped) return
            SystemClock.sleep(1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStopCurrentWork(): Boolean {
        Log.d(TAG, "onStopCurrentWork")
        return super.onStopCurrentWork()
    }

}