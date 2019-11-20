package com.shady.tiger.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(JobsMockData::class), version = 1, exportSchema = false)
abstract class AppDB: RoomDatabase() {
    abstract fun jobDao(): JobDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDatabase(context: Context): AppDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "jobs_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}