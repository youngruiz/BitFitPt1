package com.example.bitfit_pt1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercise_table")
    fun getAll(): List<ExerciseEntity>

    @Insert
    fun insertAll(exercise: List<ExerciseEntity>)

    @Insert
    fun insert(exercise: ExerciseEntity)

//    @Query("DELETE FROM article_table")
//    fun deleteAll()
}

