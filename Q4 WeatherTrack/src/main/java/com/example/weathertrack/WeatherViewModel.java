public class WeatherViewModel extends AndroidViewModel {
    private WeatherRepository repository;
    public LiveData<List<WeatherData>> weekData;
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public WeatherViewModel(@NonNull Application app) {
        super(app);
        repository = new WeatherRepository(app);
        weekData = repository.getWeekData();
    }

    public void refreshWeather() {
        repository.fetchWeather(errorMessage::postValue);
    }
}
