package com.example.bitfit_pt1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_exercise)

        val submitButton = findViewById<Button>(R.id.SubmitButton)

        submitButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.exerciseNameEt).text.toString()
            val time = findViewById<EditText>(R.id.exerciseDurationEt).text.toString()
            val calories = findViewById<EditText>(R.id.exerciseCaloriesEt).text.toString()

            // Save this exersize to the database.
            lifecycleScope.launch(IO) {
                (application as MyApplication).db.ExerciseDao().insert(
                    ExerciseEntity(name, time, calories)
                )
            }
        }


    }



}
