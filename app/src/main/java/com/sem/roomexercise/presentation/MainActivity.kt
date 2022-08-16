package com.sem.roomexercise.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sem.roomexercise.R
import com.sem.roomexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.mainContent, TownFragment()).commit()
    }

}