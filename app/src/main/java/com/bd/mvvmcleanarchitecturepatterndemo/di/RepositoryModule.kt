package com.bd.mvvmcleanarchitecturepatterndemo.di

import com.bd.mvvmcleanarchitecturepatterndemo.data.repository.MovieRepositoryImp
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesMovieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ):MovieRepository
}