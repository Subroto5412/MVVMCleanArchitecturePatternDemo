package com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository

import com.bd.mvvmcleanarchitecturepatterndemo.common.ApiState
import com.bd.mvvmcleanarchitecturepatterndemo.data.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(): Flow<ApiState<Movies>>
}