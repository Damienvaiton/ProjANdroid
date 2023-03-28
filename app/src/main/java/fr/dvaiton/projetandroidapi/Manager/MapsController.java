package fr.dvaiton.projetandroidapi.Manager;

import android.graphics.Point;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class MapsController {
    ApiManager apimanager;

    public MapsController(){
        apimanager = ApiManager.getInstance();
    }

    public PointDEau getPointDEau(){
        return CacheManager.getInstance().getPointDEau();
    }

    public PointDEau getPointDEauFavorite(){
        return CacheManager.getInstance().getPointDEauFavorite();
    }

}
