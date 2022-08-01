package com.example.coroutinelearning

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.coroutinelearning.databinding.ActivityMainBinding
import com.example.coroutinelearning.example.ui.WeatherFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //***Sequential tasks
        /*     val sequentialTasksWithCoroutine = SequentialTasksWithCoroutine()
             sequentialTasksWithCoroutine.startSequentialProcess()*/

        //***Run blocking
        /*  val runBlockingSample = RunBlockingSample()
          runBlockingSample.startSequentialProcess()*/

        val fragment: Fragment = WeatherFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(binding.frameLayout.id, fragment)
            .addToBackStack(fragment::class.java.simpleName).commit()
    }
}