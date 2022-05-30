package com.example.coroutinelearning.sequential

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.system.measureTimeMillis

class SequentialTasksWithCoroutine {

    fun startSequentialProcess() {
        CoroutineScope(IO).launch {
            val timeExecution1 = measureTimeMillis {
                val result1 = async {
                    Log.d(
                        "CoroutineLog: ",
                        "launching job1 on thread ${Thread.currentThread().name}"
                    )
                    callFakeApi1()
                }.await()
                // await() means until result1 is not prepared, lines after this doesn't execute
                // and it sits here to get result1

                val result2 = async {
                    Log.d(
                        "CoroutineLog: ",
                        "launching job2 on thread ${Thread.currentThread().name}"
                    )
                    try {
                        callFakeApi2(result1)
                    } catch (e: Exception) {
                        e.message
                    }
                }.await()

                Log.d(
                    "CoroutineLog: ", "fakeApi2 result is $result2"
                )
            }
            Log.d(
                "CoroutineLog: ", "time execution is $timeExecution1"
            )
        }
    }

    private suspend fun callFakeApi2(resultOfFakeApi1: String): String {
        delay(1000)
        if (resultOfFakeApi1.equals("Neda is learning coroutine"))
            return "Neda is coding...."
        else
            throw CancellationException("Result of fakeApi1 is incorrect")
    }

    private suspend fun callFakeApi1(): String {
        delay(1500)
        return "Neda is learning coroutine"
    }
}