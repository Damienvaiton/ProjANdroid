package fr.dvaiton.projetandroidapi.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface eauService {
    @GET ("api/records/1.0/search/?dataset=stations-eau-potable&q=&rows=100&facet=commune&facet=type&facet=etat&facet=qualite")
    Call<eauService> getEau();



}
