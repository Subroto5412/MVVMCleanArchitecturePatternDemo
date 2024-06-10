package com.bd.mvvmcleanarchitecturepatterndemo

import android.util.Log
import javax.inject.Inject

class UserRepo @Inject constructor() {
    fun saveUser(email: String){
        Log.e("Save email", "$email")
    }
}