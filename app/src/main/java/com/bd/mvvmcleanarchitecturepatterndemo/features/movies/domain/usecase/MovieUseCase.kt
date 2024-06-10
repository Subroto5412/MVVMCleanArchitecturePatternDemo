package com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.usecase

import com.bd.mvvmcleanarchitecturepatterndemo.common.ApiState
import com.bd.mvvmcleanarchitecturepatterndemo.common.map
import com.bd.mvvmcleanarchitecturepatterndemo.data.model.Movies
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.mapper.MovieMapper
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class MovieUseCase @Inject constructor(
    private val repo: MovieRepository,
    private val movieMapper:MovieMapper
) {

    suspend fun getMovies(): Flow<ApiState<List<Movies.Results>?>>  {
        return repo.getMovies().map { results ->
            results.map {
                movieMapper.fromMap(it)
            }

        }
    }

}