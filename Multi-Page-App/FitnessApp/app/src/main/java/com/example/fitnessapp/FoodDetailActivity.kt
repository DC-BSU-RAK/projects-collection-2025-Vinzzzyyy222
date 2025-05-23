package com.example.fitnessapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        supportActionBar?.title = "FitLife"

        val name = intent.getStringExtra("name")
        val details = intent.getStringExtra("details")
        val benefits = intent.getStringExtra("benefits")

        findViewById<TextView>(R.id.tvFoodDetailName).text = name
        findViewById<TextView>(R.id.tvFoodDetails).text = details
        findViewById<TextView>(R.id.tvFoodBenefits).text = "Benefits: $benefits"
    }
}
