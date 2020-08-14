package com.lirui.jetpack.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("delete from student where id=:id")
    fun deleteStudentById(id: Int)

    @Query("delete from student")
    fun deleteAllData()

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getStudentList(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): Student
}