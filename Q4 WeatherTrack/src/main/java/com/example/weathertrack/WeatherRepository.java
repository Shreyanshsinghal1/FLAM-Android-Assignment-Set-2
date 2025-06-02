public class WeatherRepository {
    private WeatherDao dao;
    private Context context;

    public WeatherRepository(Application app) {
        WeatherDatabase db = Room.databaseBuilder(app, WeatherDatabase.class, "weather_db").build();
        dao = db.weatherDao();
        context = app.getApplicationContext();
    }

    public LiveData<List<WeatherData>> getWeekData() {
        long weekAgo = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7);
        return dao.getLast7DaysData(weekAgo);
    }

    public void fetchWeather(Consumer<String> onError) {
        try {
            InputStream is = context.getAssets().open("weather.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());

            WeatherData data = new WeatherData();
            data.temperature = (float) json.getDouble("temperature");
            data.humidity = json.getInt("humidity");
            data.condition = json.getString("condition");
            data.timestamp = System.currentTimeMillis();

            Executors.newSingleThreadExecutor().execute(() -> dao.insert(data));

        } catch (Exception e) {
            onError.accept("Failed to fetch weather data");
        }
    }
}
