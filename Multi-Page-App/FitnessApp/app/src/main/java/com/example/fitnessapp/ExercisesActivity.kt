package com.example.fitnessapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.fitnessapp.Exercise
import com.example.fitnessapp.ExercisesAdapter

class ExercisesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var exercisesAdapter: ExercisesAdapter

    private val exerciseList = listOf(
        Exercise(
            "Push-ups",
            "Great for chest, shoulders, and triceps.",
            "Push-ups are a bodyweight exercise performed in a prone position by raising and lowering the body using the arms.",
            "Improves upper body strength, core stability, and overall endurance.",
                    R.drawable.push_ups
        ),
        Exercise(
            "Squats",
            "Builds lower body strength.",
            "Squats involve bending the knees and hips to lower the torso and return to standing position.",
            "Enhances leg strength, boosts core stability, and improves balance and mobility.",
                    R.drawable.squats
        ),
        Exercise(
            "Plank",
            "Core strengthening and endurance.",
            "A plank involves holding a push-up-like position with the body straight and supported by the forearms and toes.",
            "Improves core strength, posture, and overall muscular endurance.",
                    R.drawable.plank
        ),
        Exercise(
            "Jumping Jacks",
            "Good warm-up and cardio.",
            "Jumping jacks involve jumping to a position with legs spread wide and hands touching overhead, then returning to the starting position.",
            "Boosts cardiovascular health, warms up muscles, and increases coordination.",
                    R.drawable.jumping_jacks
        ),
        Exercise(
            "Lunges",
            "Improves balance and leg strength.",
            "Lunges involve stepping forward with one leg and lowering the body until both knees are bent at about a 90-degree angle.",
            "Enhances balance, strengthens legs and glutes, and improves flexibility.",
                    R.drawable.lunges
        ),
        Exercise(
            "Burpees",
            "Full-body strength and cardio.",
            "Burpees are a full-body exercise involving a squat, a jump to a push-up position, a push-up, and a jump back up.",
            "Boosts cardiovascular fitness, burns calories, and builds strength and endurance.",
                    R.drawable.burpees
        ),
        Exercise(
            "Sit-ups",
            "Strengthens abdominal muscles.",
            "Sit-ups involve lying on the back and lifting the torso to a sitting position using abdominal muscles.",
            "Improves core strength and abdominal endurance.",
                    R.drawable.sit_ups
        ),
        Exercise(
            "Mountain Climbers",
            "Core and cardio workout.",
            "Mountain climbers are performed in a plank position by alternating leg drives toward the chest rapidly.",
            "Combines core strengthening with cardiovascular endurance.",
                    R.drawable.mountain_climbers
        ),
        Exercise(
            "Bicycle Crunches",
            "Targets abs and obliques.",
            "Bicycle crunches involve lying on your back, lifting your legs, and alternating elbow-to-knee crunches in a pedaling motion.",
            "Engages abdominal muscles, especially obliques, and improves core definition.",
                    R.drawable.bicycle_crunches
        ),
        Exercise(
            "Tricep Dips",
            "Strengthens triceps and shoulders.",
            "Performed by lowering and lifting the body using the arms behind you on a bench or chair.",
            "Tones the triceps, shoulders, and chest while improving upper body strength.",
                    R.drawable.tricep_dips
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)
        supportActionBar?.title = "FitLife"

        recyclerView = findViewById(R.id.recyclerViewExercises)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Pass a lambda to handle click events on exercises
        exercisesAdapter = ExercisesAdapter(exerciseList) { exercise ->
            val intent = Intent(this, ExerciseDetailActivity::class.java).apply {
                putExtra("name", exercise.name)
                putExtra("details", exercise.details)
                putExtra("benefits", exercise.benefits)
            }
            startActivity(intent)
        }

        recyclerView.adapter = exercisesAdapter
    }

}

