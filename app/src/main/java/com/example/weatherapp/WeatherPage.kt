package com.example.weatherapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.api.NetworkResponse
import com.example.weatherapp.api.WeatherModel

@Composable
fun WeatherPage(viewModel: WeatherViewModel){

    var city by remember { mutableStateOf("") }
    val weatherResult = viewModel.weatherResult.observeAsState()

    Column(
        modifier = Modifier.fillMaxWidth().padding(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = city,
                onValueChange = {city = it},
                label = {Text("Enter City")},)
            IconButton(onClick = {
                viewModel.getData(city)
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        }
        when(val result = weatherResult.value){
            is NetworkResponse.Error->{Text(text = result.message)}
            NetworkResponse.Loading->{
                CircularProgressIndicator()
            }
            is NetworkResponse.Success->{
                WeatherDetails(data = result.data)
            }
            null -> {}
        }

    }
}

@Composable
fun WeatherDetails(data: WeatherModel) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom,
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location Icon"
            )
            Text(text = data.location.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = data.location.country, fontSize = 18.sp, color = Color.Gray)

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "${data.current.temp_c} ° C",
            fontSize = 68.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = data.current.condition.text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    WeatherCard(key = "Humidity", value = "${data.current.humidity}%")
                    WeatherCard(key = "UV", value = data.current.uv)
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    WeatherCard(key = "Wind", value = "${data.current.wind_kph} km/h")
                    WeatherCard(key = "Pressure", value = "${data.current.pressure_mb} mb")
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    WeatherCard(key = "Cloud", value = "${data.current.cloud}%")
                    WeatherCard(key = "Visibility", value = "${data.current.vis_km} km")
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    WeatherCard(key = "Feels Like", value = "${data.current.feelslike_c} ° C")
                    WeatherCard(key = "Last Updated", value = data.current.last_updated)
                }
            }
        }
    }
}

@Composable
fun WeatherCard(key: String, value: String){
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text(text = key, fontSize = 18.sp, color = Color.Gray, textAlign = TextAlign.Center)
    }
}