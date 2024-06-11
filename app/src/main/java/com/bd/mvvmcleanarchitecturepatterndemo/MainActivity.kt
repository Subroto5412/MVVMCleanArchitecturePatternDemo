package com.bd.mvvmcleanarchitecturepatterndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.ui.MovieScreen
import com.bd.mvvmcleanarchitecturepatterndemo.features.movies.ui.MovieViewModel
import com.bd.mvvmcleanarchitecturepatterndemo.ui.theme.MVVMCleanArchitecturePatternDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCleanArchitecturePatternDemoTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    MovieScreen()
                }
            }
        }
    }
}