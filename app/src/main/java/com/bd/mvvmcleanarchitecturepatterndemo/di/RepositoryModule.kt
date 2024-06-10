package com.bd.mvvmcleanarchitecturepatterndemo.di

import com.bd.mvvmcleanarchitecturepatterndemo.data.repository.MovieRepositoryImpl
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository.MovieRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    abstract fun providesMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}