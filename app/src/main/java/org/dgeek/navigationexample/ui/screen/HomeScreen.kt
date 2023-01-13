package org.dgeek.navigationexample.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import org.dgeek.navigationexample.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeViewModel = viewModel()) {
    val number by viewModel.number.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.increment() }) {
            Text(text = "IncreaseCount  $number")
        }
    }
}