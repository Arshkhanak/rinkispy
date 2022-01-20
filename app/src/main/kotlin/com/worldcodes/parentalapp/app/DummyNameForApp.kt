package com.worldcodes.parentalapp.app

import android.app.Application
import androidx.multidex.MultiDex
import com.chrisplus.rootmanager.RootManager
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.worldcodes.parentalapp.di.component.AppComponent
import com.worldcodes.parentalapp.di.component.DaggerAppComponent
import com.worldcodes.parentalapp.di.module.AppModule
import com.worldcodes.parentalapp.di.module.FirebaseModule
import com.worldcodes.parentalapp.utils.Consts.SIZE_CACHE_FIREBASE

/**
 * Created by samuel incoom on 28/03/15.
 */
class DummyNameForApp : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
        lateinit var root: RootManager
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).firebaseModule(FirebaseModule()).build()
        appComponent.inject(this)

        root = RootManager.getInstance()

        if (FirebaseApp.getApps(this).isNotEmpty()) {
            val database = FirebaseDatabase.getInstance()
            database.setPersistenceEnabled(true)
            database.setPersistenceCacheSizeBytes(SIZE_CACHE_FIREBASE)
        }

    }

}