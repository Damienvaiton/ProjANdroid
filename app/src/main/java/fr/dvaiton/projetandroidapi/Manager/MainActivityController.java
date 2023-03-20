package fr.dvaiton.projetandroidapi.Manager;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import fr.dvaiton.projetandroidapi.MainActivity;
import fr.dvaiton.projetandroidapi.Model.PointDEau;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.QueryMap;

public class MainActivityController {

private static ApiManager apimanager;


public MainActivityController (){
    apimanager = ApiManager.getInstance();
}

    public static ApiManager getApimanager() {
        return apimanager;
    }
    public void loadEau(PointDEauDataManagerCallback callback){
    for (int i = 0; i < 10; i++) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("dataset", "hydrographie-points-deau-en-france");
        queryMap.put("rows", "100");
        queryMap.put("start", String.valueOf(i * 100));

    apimanager.getEauService().getPointDEau().enqueue(new Callback<PointDEau>() {
        @Override
        public void onResponse(Call<PointDEau> call, Response<PointDEau> response) {
            if (response.isSuccessful()) {


               PointDEau point = response.body();

               callback.getTimeResponseSuccess(point);



            }
            else {
                callback.getTimeResponseError("Error");
            }
        }

        @Override
        public void onFailure(Call<PointDEau> call, Throwable t) {
            Log.d("TAG", "onFailure: " + t.getMessage());

        }
    });
    }
    }
}
