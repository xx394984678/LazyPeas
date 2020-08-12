package com.lirui.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lirui.jetpack.life_cycle.TestLifeCycleObserver
import com.lirui.jetpack.room.MyDatabase
import com.lirui.jetpack.room.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(TestLifeCycleObserver())
        val database = MyDatabase.getInstance(this)

        scope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                database.studentDao().insertStudent(Student(1,"zhangsan","11"))
                database.studentDao().insertStudent(Student(2,"sdf","11"))
                database.studentDao().insertStudent(Student(3,"wefc","11"))
                database.studentDao().insertStudent(Student(4,"scvw","11"))
            }
            val list = withContext(Dispatchers.IO){
                database.studentDao().getStudentList()
            }
            for (student in list) {
                println(student.name)
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }
}
