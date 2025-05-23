package com.example.fitnessapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.title = "FitLife"


        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnSave = findViewById(R.id.btnSaveProfile)

        loadProfile()

        btnSave.setOnClickListener {
            saveProfile()
        }
    }

    private fun saveProfile() {
        val name = etName.text.toString()
        val age = etAge.text.toString()
        val height = etHeight.text.toString()
        val weight = etWeight.text.toString()

        if (name.isBlank() || age.isBlank() || height.isBlank() || weight.isBlank()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val sharedPref = getSharedPreferences("user_profile", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("name", name)
            putInt("age", age.toInt())
            putFloat("height", height.toFloat())
            putFloat("weight", weight.toFloat())
            apply()
        }

        Toast.makeText(this, "Profile saved!", Toast.LENGTH_SHORT).show()
    }

    private fun loadProfile() {
        val sharedPref = getSharedPreferences("user_profile", Context.MODE_PRIVATE)
        etName.setText(sharedPref.getString("name", ""))
        etAge.setText(sharedPref.getInt("age", 0).takeIf { it != 0 }?.toString() ?: "")
        etHeight.setText(sharedPref.getFloat("height", 0f).takeIf { it != 0f }?.toString() ?: "")
        etWeight.setText(sharedPref.getFloat("weight", 0f).takeIf { it != 0f }?.toString() ?: "")
    }
}
