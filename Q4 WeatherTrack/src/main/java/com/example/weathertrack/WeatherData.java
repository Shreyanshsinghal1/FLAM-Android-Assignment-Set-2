@Entity(tableName = "weather_data")
public class WeatherData {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public float temperature;
    public int humidity;
    @NonNull
    public String condition;
    public long timestamp;
}
