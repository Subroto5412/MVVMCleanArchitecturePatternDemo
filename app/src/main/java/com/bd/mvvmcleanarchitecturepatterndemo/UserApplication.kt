package com.bd.mvvmcleanarchitecturepatterndemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class UserApplication: Application() {

    @Inject
    lateinit var userRepo: UserRepo
    override fun onCreate() {
        super.onCreate()
        userRepo.saveUser("subroto.mohonto@gmail.com")
    }
}