package com.lirui.jetpack

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.lirui.jetpack.life_cycle.ApplicationObserver
import com.lirui.lazypeas.library.http.HttpUtilConfig

class App : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())

        HttpUtilConfig.CONFIG.setBaseDebugUrl("")
                .setBaseOnLineUrl("")
                .setConnectType(HttpUtilConfig.ON_LINE_CONNECT_TYPE)
    }


}