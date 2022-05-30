package com.example.coroutinelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinelearning.databinding.ActivityMainBinding
import com.example.coroutinelearning.sequential.SequentialTasksWithCoroutine

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sequentialTasksWithCoroutine = SequentialTasksWithCoroutine()
        sequentialTasksWithCoroutine.startSequentialProcess()
    }
}