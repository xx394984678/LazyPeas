package com.lirui.jetpack.life_cycle

import android.util.Log
import androidx.lifecycle.LifecycleOwner

class TestChildObserver:TestLifeCycleObserver() {
    private val TAG = "TestChildObserver"
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TAG, "onCreate: ")
    }


}