package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "FitLife"


        // 👇 Always show the instructions popup on every app launch
        startActivity(Intent(this, AppInstructionsActivity::class.java))

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnExercises = findViewById<Button>(R.id.btnExercises)
        val btnFoods = findViewById<Button>(R.id.btnFoods)


        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnExercises.setOnClickListener {
            startActivity(Intent(this, ExercisesActivity::class.java))
        }

        btnFoods.setOnClickListener {
            startActivity(Intent(this, FoodsActivity::class.java))
        }
    }
}
