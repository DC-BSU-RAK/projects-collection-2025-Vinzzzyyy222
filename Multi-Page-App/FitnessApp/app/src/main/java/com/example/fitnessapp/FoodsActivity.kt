package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    private val foodList = listOf(
        Food("🥦 Broccoli", "Rich in vitamins and fiber.", "Broccoli is a cruciferous vegetable packed with vitamins C and K, fiber, and antioxidants.", "Supports immune health and digestion."),
        Food("🐟 Salmon", "Great source of Omega-3.", "Salmon is a fatty fish rich in Omega-3 fatty acids and high-quality protein.", "Improves heart health and brain function."),
        Food("🍚 Quinoa", "High in protein and gluten-free.", "Quinoa is a grain crop known for its edible seeds, loaded with protein and essential amino acids.", "Provides long-lasting energy and helps muscle repair."),
        Food("🫐 Blueberries", "Loaded with antioxidants.", "Blueberries are low in calories but high in fiber, vitamin C, and antioxidants.", "Boosts brain health and reduces inflammation."),
        Food("🥑 Avocado", "Healthy fats and fiber.", "Avocados are nutrient-dense fruits rich in heart-healthy monounsaturated fats.", "Helps with cholesterol and nutrient absorption."),
        Food("🍎 Apple", "Fiber-rich and hydrating.", "Apples are a great source of fiber and antioxidants.", "Supports digestion and heart health."),
        Food("🍌 Banana", "Energizing and rich in potassium.", "Bananas provide quick energy and essential nutrients like potassium.", "Supports muscle function and heart health."),
        Food("🥕 Carrots", "High in beta-carotene.", "Carrots are crunchy vegetables rich in vitamin A and fiber.", "Promotes eye health and immune function."),
        Food("🍓 Strawberries", "Sweet and rich in vitamin C.", "Strawberries are loaded with antioxidants and vitamins.", "Improves skin, heart health, and immunity."),
        Food("🥜 Almonds", "Packed with healthy fats and protein.", "Almonds are nutrient-dense nuts high in vitamin E, magnesium, and antioxidants.", "Boosts brain function and supports heart health.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)
        supportActionBar?.title = "Fitlife"


        recyclerView = findViewById(R.id.recyclerViewFoods)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodAdapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra("name", food.name)
                putExtra("details", food.details)
                putExtra("benefits", food.benefits)
            }
            startActivity(intent)
        }

        recyclerView.adapter = foodAdapter
    }
}
