package com.xjw.library.base

import android.app.Application

/**
 * Created by xjw on 2020/8/10 11:47
 */
class App : Application() {

    companion object {
        private lateinit var application: App

        fun get(): Application = application
    }

    override fun onCreate() {
        super.onCreate()

        application = this
        init()
    }

    private fun init() {
    }

}