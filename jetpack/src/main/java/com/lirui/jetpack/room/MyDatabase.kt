package com.lirui.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 2)
abstract class MyDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        private val DATABASE_NAME = "my_db"

        @Volatile
        private var databaseInstance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (databaseInstance == null) {
                synchronized(this) {
                    if (databaseInstance == null) {
                        databaseInstance = Room
                                .databaseBuilder(context.applicationContext, MyDatabase::class.java, DATABASE_NAME)
                                .allowMainThreadQueries()
                                .fallbackToDestructiveMigration()
                                .addMigrations(mMigration)
                                .build()
                    }
                }
            }
            return databaseInstance!!
        }

        private val mMigration :Migration=object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD sex TEXT ")
            }
        }
    }



}