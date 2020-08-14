package com.lirui.jetpack

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.lirui.jetpack.life_cycle.TestLifeCycleObserver
import com.lirui.jetpack.room.MyDatabase
import com.lirui.jetpack.room.Student
import com.lirui.jetpack.view_model.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity1"

    val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(TestLifeCycleObserver())
        val model = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(StudentViewModel::class.java)
        model.mLiveData?.observe(this, Observer {
            it.forEach { student: Student ->
                Log.d(TAG, "onCreate:${student.name}")
            }
        })


        sign_text.setOnClickListener {
            MyDatabase.getInstance(this).studentDao().insertStudent(Student("new","new","man"))
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
