package fr.dvaiton.projetandroidapi.Manager;

import java.util.HashMap;

import fr.dvaiton.projetandroidapi.service.eauService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    final String BASE_URL = "https://public.opendatasoft.com/";

    private static ApiManager instance;

    private eauService eauService = null;

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }

        return instance;
    }

    public eauService getEauService() {
        return eauService;
    }

    private ApiManager() {
        createRetrofitEau();
    }

    private void createRetrofitEau() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitEau = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eauService = retrofitEau.create(eauService.class);

    }

}


