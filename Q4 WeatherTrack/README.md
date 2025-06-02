## WeatherTrack App

WeatherTrack is a simple Android app that fetches and tracks daily weather stats using a mock API. It stores weather data every 6 hours using WorkManager and provides a weekly temperature summary.

---

##  Features

- **Fetch Weather:** Retrieve current weather data (temperature, humidity, condition) from a mock/static JSON file.
- **Local Storage:** Save weather data into a local Room database with a timestamp.
- **Auto Background Sync:** Automatically fetch weather data every 6 hours using WorkManager.
- **Manual Refresh:** Button to manually fetch and store weather data.
- **Weekly Summary:** Display temperature trends over the past 7 days in a RecyclerView.
- **Daily Details:** Tap on a day to view detailed weather stats (feature-ready for future).
- **Offline-first:** Works without internet once data is cached.
- **User-Friendly Errors:** Proper messages for API, DB, and network issues.

---

##  Tech Stack

- **Language:** Java  
- **Architecture:** MVVM  
- **Database:** Room  
- **Background Tasks:** WorkManager  
- **UI:** RecyclerView, LiveData, ViewModel  
- **Mock API:** Local static `weather.json` in `assets/`

---

##  Project Structure

```plaintext
WeatherTrackApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/weathertrack/
│   │   │   │   ├── WeatherData.java
│   │   │   │   ├── WeatherDao.java
│   │   │   │   ├── WeatherDatabase.java
│   │   │   │   ├── WeatherRepository.java
│   │   │   │   ├── WeatherViewModel.java
│   │   │   │   ├── WeatherWorker.java
│   │   │   │   └── MainActivity.java
│   │   │   ├── res/layout/
│   │   │   │   └── activity_main.xml
│   │   │   ├── assets/
│   │   │   │   └── weather.json
│   └── build.gradle


##  Setup Instructions

1. **Clone or download** the project.
2. Open in **Android Studio**.
3. Sync Gradle and build the project.
4. Run the app on an emulator or device.
5. Tap **Refresh** to fetch mock weather data.
6. Observe data being stored and updated every 6 hours automatically.

---

##  Dependencies

```groovy
implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
implementation "androidx.room:room-runtime:2.5.2"
annotationProcessor "androidx.room:room-compiler:2.5.2"
implementation "androidx.work:work-runtime:2.9.0"
implementation "androidx.recyclerview:recyclerview:1.3.2"
implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0' // optional for graphs
