public class WeatherWorker extends Worker {
    public WeatherWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        WeatherRepository repository = new WeatherRepository((Application) getApplicationContext());
        repository.fetchWeather(e -> {});
        return Result.success();
    }
}
