package com.lirui.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        private val DATABASE_NAME = "my_db"

        @Volatile
        private var databaseInstance: MyDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MyDatabase {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()
            }
            return databaseInstance!!
        }
    }



}