# WeatherApp for Android

A simple Android application that displays current weather information for a specified city using a free weather API. 
This project demonstrates the use of modern Android development practices including Jetpack Compose for UI, Kotlin Coroutines for asynchronous operations, ViewModel for UI-related data, and Retrofit for networking.

## Screenshots of the application
<img width="540" height="1212" alt="Screenshot_20250825_131420" src="https://github.com/user-attachments/assets/d43f5223-4f49-4341-8e3e-1b68986caf1a" />
<img width="540" height="1212" alt="Screenshot_20250825_131344" src="https://github.com/user-attachments/assets/bfb7cbe8-d22e-490b-a604-99351abd7c0b" />

## Features

*   Fetch current weather data for a given city.
*   Display temperature, weather condition, wind speed, and humidity.
*   User-friendly interface built with Jetpack Compose.
*   Handles API errors and network issues gracefully.


## API Used

This project uses the WeatherAPI.com to fetch weather data.
You will need to obtain a free API key from https://www.weatherapi.com/ to run the application.


## Tech Stack & Open-source Libraries
1. [Kotlin](https://kotlinlang.org/)**: First-class and official programming language for Android development.
2. [Jetpack Compose](https://developer.android.com/jetpack/compose)**: Android’s modern toolkit for building native UI.
3. [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)**: For asynchronous programming.
4. [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: Manages UI-related data in a lifecycle-conscious way.
5. [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)**: For observing data changes in a reactive way.
6. [Retrofit 2](https://square.github.io/retrofit/)**: A type-safe HTTP client for Android and Java.
7. [Gson](https://github.com/google/gson)**: A Java serialization/deserialization library to convert Java Objects into JSON and back (used with Retrofit).

