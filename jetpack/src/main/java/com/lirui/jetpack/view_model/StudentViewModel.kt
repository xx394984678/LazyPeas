package com.lirui.jetpack.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lirui.jetpack.room.MyDatabase
import com.lirui.jetpack.room.Student

class StudentViewModel:AndroidViewModel {
    var mLiveData: LiveData<List<Student>>? = null

    constructor(application: Application) : super(application){
        mLiveData = MyDatabase.getInstance(application).studentDao().getStudentList()
    }
}