package com.peiandsky.base

import android.app.Application
import com.peiandsky.uilibtest.popup.ToastyConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ToastyConfig.config()
    }
}