package com.example.fitnessapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExercisesAdapter(
    private val exerciseList: List<Exercise>,
    private val onItemClick: (Exercise) -> Unit
) : RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder>() {

    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvExerciseName: TextView = itemView.findViewById(R.id.textExerciseName)
        val tvExerciseDesc: TextView = itemView.findViewById(R.id.textExerciseDescription)

        init {
            itemView.setOnClickListener {
                val exercise = exerciseList[adapterPosition]
                val context = itemView.context
                val intent = Intent(context, ExerciseDetailActivity::class.java).apply {
                    putExtra("name", exercise.name)
                    putExtra("details", exercise.details)
                    putExtra("benefits", exercise.benefits)
                    putExtra("imageResId", exercise.imageResId)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exerciseList[position]
        holder.tvExerciseName.text = exercise.name
        holder.tvExerciseDesc.text = exercise.shortDescription
    }

    override fun getItemCount(): Int = exerciseList.size
}
