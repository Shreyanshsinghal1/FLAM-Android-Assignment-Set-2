@Dao
public interface WeatherDao {
    @Insert
    void insert(WeatherData data);

    @Query("SELECT * FROM weather_data WHERE timestamp > :startTime ORDER BY timestamp DESC")
    LiveData<List<WeatherData>> getLast7DaysData(long startTime);

    @Query("SELECT * FROM weather_data ORDER BY timestamp DESC LIMIT 1")
    LiveData<WeatherData> getLatestData();
}
