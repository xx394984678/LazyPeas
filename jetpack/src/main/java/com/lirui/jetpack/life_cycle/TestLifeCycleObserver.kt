package com.lirui.jetpack.life_cycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

open class TestLifeCycleObserver :LifecycleObserver{

    private val TAG = "TestLifeCycleObserver"
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop: ")
    }

}