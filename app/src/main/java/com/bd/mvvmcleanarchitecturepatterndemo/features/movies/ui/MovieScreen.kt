package com.bd.mvvmcleanarchitecturepatterndemo.features.movies.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.request.ImageResult
import coil.transform.CircleCropTransformation
import com.bd.mvvmcleanarchitecturepatterndemo.R
import com.bd.mvvmcleanarchitecturepatterndemo.data.model.Movies
import com.bd.mvvmcleanarchitecturepatterndemo.data.network.ApiService

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel()
){
    val res = viewModel.res.value
    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            CircleCropTransformation()
        }
    }

    if (res.error.isNotEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Text(text = res.error)
        }
    }

    if(res.data.isNotEmpty()){
      LazyColumn {
          items(res.data,
              key = {
                  it.id!!
              }){ res ->
              EachRow(res = res)
          }
      }
    }

}

@Composable
fun EachRow(
    res: Movies.Results
){
    Card(modifier = Modifier.fillMaxSize().padding(8.dp), elevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp
    ),colors = CardDefaults.cardColors(
        containerColor = Color(0xFFF7F2F9),
    ), shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${ApiService.BASE_POSTER_URL}${res.poster_path}")
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .transformations(CircleCropTransformation())
            ), contentDescription = "",
                modifier = Modifier.size(100.dp)
                    .padding(10.dp))
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterVertically)) {
                Text(text = res.original_title!!, style = TextStyle(fontSize = 16.sp), textAlign = TextAlign.Center)
                Text(text = res.overview!!, style = TextStyle(fontSize = 12.sp), textAlign = TextAlign.Center)

            }
        }
    }
}