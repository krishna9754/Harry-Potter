package com.example.harrypotter.ui.appUi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.harrypotter.viewmodel.MainViewModel

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = MainViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    if (state.isEmpty()) {
        LoadingScreen()
    } else {
        LazyVerticalGrid(modifier = Modifier.padding(top = 40.dp), columns = GridCells.Fixed(2)) {
            items(state) {

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(200.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(10.dp)
                            )
                    )
                    Text(
                        text = "Name: ${it.name}",
                        modifier = Modifier
                            .padding(5.dp),
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Actor: ${it.actor}",
                        modifier = Modifier
                            .padding(5.dp),
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        Text(
                            text = "Species: ${it.species},",
                            modifier = Modifier
                                .padding(5.dp),
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = it.gender,
                            modifier = Modifier
                                .padding(5.dp),
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

}
