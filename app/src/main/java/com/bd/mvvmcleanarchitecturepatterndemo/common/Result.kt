package com.bd.mvvmcleanarchitecturepatterndemo.common

sealed class Result<out T> {
    data class Success<out R>(val data: R) : Result<R>()
    data class Failure(val msg: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString():String {
        return when (this) {
            is Success<*> -> "Success $data"
            is Failure -> "Failure $msg"
            Loading -> "Loading"
        }
    }
}
