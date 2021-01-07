package com.lirui.jetpack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.lirui.jetpack.life_cycle.TestChildObserver
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
    lateinit var testLiveData:MutableLiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        lifecycle.addObserver(TestChildObserver())
//
//        val model = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(StudentViewModel::class.java)
//        model.mLiveData?.observe(this, Observer {
//            it.forEach { student: Student ->
//                Log.d(TAG, "onCreate:${student.name}")
//            }
//        })
//        testLiveData = MutableLiveData("hahah")
//        testLiveData.observe(this, Observer {
//            sign_text.text = it
//        })
//
//        sign_text.setOnClickListener {
////            MyDatabase.getInstance(this).studentDao().insertStudent(Student("new","new","man"))
//            startActivity(Intent(this, MainActivity::class.java))
//        }
        val dao = MyDatabase.getInstance(this).studentDao()
//        dao.insertStudent(Student(1, "aaa", "2", "男"))
//        dao.insertStudent(Student(0, "bbb", "42", "女"))
//        dao.insertStudent(Student(0, "ccc", "32", "男"))
//        dao.insertStudent(Student(0, "ddd", "12", "男"))

        dao.insertStudent(Student(2, "aaa", "3", "男"))

    }

    override fun onResume() {
        super.onResume()
    }
}
