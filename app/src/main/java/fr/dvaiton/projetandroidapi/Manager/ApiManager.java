package fr.dvaiton.projetandroidapi.Manager;

import fr.dvaiton.projetandroidapi.service.eauService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    final String BASE_URL = "hhttps://public.opendatasoft.com/api/records/1.0/search/?dataset=hydrographie-points-deau-en-france&q=&facet=nature&facet=commune";

    private static ApiManager instance;

    private eauService eauService = null;

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }

        return instance;
    }

    private ApiManager() {

        createRetrofitEau();
    }

    private void createRetrofitEau() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitClock = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eauService = retrofitClock.create(fr.dvaiton.projetandroidapi.service.eauService.class);

    }

}


