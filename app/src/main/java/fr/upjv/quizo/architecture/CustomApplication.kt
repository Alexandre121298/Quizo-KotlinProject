package fr.upjv.quizo.architecture

import android.app.Application
import androidx.room.Room

class CustomApplication : Application() {
    companion object {
        lateinit var instance: CustomApplication
    }

    lateinit var mApplicationDatabase: CustomRoomDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this

        mApplicationDatabase = Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "QuizzDatabase"
        ).fallbackToDestructiveMigration().build()
    }
}