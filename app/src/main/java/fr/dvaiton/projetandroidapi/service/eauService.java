package fr.dvaiton.projetandroidapi.service;

import java.util.Map;

import fr.dvaiton.projetandroidapi.Model.PointDEau;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface eauService {
    @GET("api/records/1.0/search/?dataset=hydrographie-points-deau-en-france")
    Call<PointDEau> getPointDEau(@Query("start") int start, @Query("rows") int rows);






}
