package com.bd.mvvmcleanarchitecturepatterndemo.data.repository

import com.bd.mvvmcleanarchitecturepatterndemo.common.base.BaseRepository
import com.bd.mvvmcleanarchitecturepatterndemo.data.model.Movies
import com.bd.mvvmcleanarchitecturepatterndemo.data.network.ApiService
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService: ApiService) : BaseRepository(), MovieRepository{
    override suspend fun getMovies(): Flow<Result<Movies>> = safeApiCall(){
       apiService.getMoviesList()
    }
}