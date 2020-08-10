package com.xjw.update

import android.app.Application

/**
 * Created by xjw on 2020/8/10 13:46
 */
class App : Application() {

    companion object {
        private lateinit var app: App

        fun get(): App = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}