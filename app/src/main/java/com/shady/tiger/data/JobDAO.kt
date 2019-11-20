package com.shady.tiger.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JobDAO {
    @Query("SELECT * from jobs_table")
    suspend fun getJobs(): List<JobsMockData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(job: JobsMockData)

    @Query("DELETE FROM jobs_table")
    suspend fun deleteAll()
}