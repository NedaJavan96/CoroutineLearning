package com.example.coroutinelearning.runblocking

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RunBlockingSample {

    fun startSequentialProcess() {
        //job #1
        CoroutineScope(Main).launch {
            Log.d(
                "CoroutineLog : ", "launching job1 on thread ${Thread.currentThread().name}"
            )
            val result1 = callFakeApi1()
            Log.d("CoroutineLog: ", result1)
            val result2 = callFakeApi2()
            Log.d("CoroutineLog: ", result2)
        }

        //job #2
        CoroutineScope(Main).launch {
            Log.d(
                "CoroutineLog : ", "launching job2 on thread ${Thread.currentThread().name}"
            )
            runBlocking {
                Log.d("CoroutineLog: ", "StartRunBlocking")
                val result = callFakeApi3()
                Log.d("CoroutineLog: ", result)
            }
        }
    }

    private suspend fun callFakeApi3(): String {
        delay(4000)
        return "Neda is learning run blocking"
    }

    private suspend fun callFakeApi2(): String {
        delay(1000)
        return "Neda is learning coroutine#2"
    }

    private suspend fun callFakeApi1(): String {
        delay(1000)
        return "Neda is learning coroutine#1"
    }
}