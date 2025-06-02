public class MainActivity extends AppCompatActivity {
    private WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        RecyclerView recycler = findViewById(R.id.recycler);
        TextView errorView = findViewById(R.id.error_text);
        Button refreshBtn = findViewById(R.id.refresh_button);

        viewModel.weekData.observe(this, data -> {
            recycler.setAdapter(new WeatherAdapter(data));
        });

        viewModel.errorMessage.observe(this, msg -> {
            errorView.setText(msg);
        });

        refreshBtn.setOnClickListener(v -> viewModel.refreshWeather());

        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(WeatherWorker.class, 6, TimeUnit.HOURS).build();
        WorkManager.getInstance(this).enqueueUniquePeriodicWork("weather_fetch", ExistingPeriodicWorkPolicy.KEEP, request);
    }
}
