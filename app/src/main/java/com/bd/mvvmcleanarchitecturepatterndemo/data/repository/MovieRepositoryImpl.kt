package com.bd.mvvmcleanarchitecturepatterndemo.data.repository

import com.bd.mvvmcleanarchitecturepatterndemo.common.ApiState
import com.bd.mvvmcleanarchitecturepatterndemo.common.base.BaseRepository
import com.bd.mvvmcleanarchitecturepatterndemo.data.model.Movies
import com.bd.mvvmcleanarchitecturepatterndemo.data.network.ApiService
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val apiService: ApiService,
) : MovieRepository, BaseRepository() {

    override suspend fun getMovies(): Flow<ApiState<Movies>> = safeApiCall {
        apiService.getMovies()
    }
}