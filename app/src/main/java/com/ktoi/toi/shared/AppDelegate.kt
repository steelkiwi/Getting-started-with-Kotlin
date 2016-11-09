package com.ktoi.toi.shared

import android.app.Application
import com.ktoi.toi.view.activities.MainActivity
import dagger.Component
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

class AppDelegate : Application() {

    var injector: AppInjector? = null

    @Singleton
    @Component(modules = arrayOf(NewsModule::class))
    interface AppInjector {

        fun inject(activity: MainActivity)

    }

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppDelegate_AppInjector.builder().build()

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }
}