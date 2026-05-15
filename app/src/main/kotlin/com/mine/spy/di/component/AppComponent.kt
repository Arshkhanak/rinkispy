package com.mine.spy.di.component

import com.mine.spy.app.DummyNameForApp
import com.mine.spy.di.module.AppModule
import com.mine.spy.di.module.FirebaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FirebaseModule::class])
interface AppComponent {
    fun inject(app: DummyNameForApp)
}
