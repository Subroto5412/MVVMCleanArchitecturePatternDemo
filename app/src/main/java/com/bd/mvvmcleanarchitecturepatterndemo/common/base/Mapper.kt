package com.bd.mvvmcleanarchitecturepatterndemo.common.base

interface Mapper<F,T> {
    fun fromMap(from: F):T
}