package com.example.fitnessapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExerciseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail)
        supportActionBar?.title = "FitLife"

        val name = intent.getStringExtra("name")
        val details = intent.getStringExtra("details")
        val benefits = intent.getStringExtra("benefits")
        val imageResId = intent.getIntExtra("imageResId", -1)

        findViewById<TextView>(R.id.tvExerciseDetailName).text = name
        findViewById<TextView>(R.id.tvExerciseDetails).text = details
        findViewById<TextView>(R.id.tvExerciseBenefits).text = "Benefits: $benefits"

        if (imageResId != -1) {
            findViewById<ImageView>(R.id.ivExerciseImage).setImageResource(imageResId)
        }
    }
}
