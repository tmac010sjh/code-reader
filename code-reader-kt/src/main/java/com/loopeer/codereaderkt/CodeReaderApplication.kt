package com.loopeer.codereaderkt

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.support.v7.app.AppCompatDelegate
import com.facebook.stetho.Stetho
import com.loopeer.codereaderkt.utils.ThemeUtils


class CodeReaderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build())
        AppCompatDelegate.setDefaultNightMode(ThemeUtils.getCurrentNightMode(this))
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var instance: CodeReaderApplication
            private set
        lateinit var appContext: Context
            private set
    }

}