package fr.dvaiton.projetandroidapi.Manager;

import android.graphics.Point;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class CacheManager {

    private PointDEau pointDEau;

    private Boolean isDark = false;

    private PointDEau pointDEauFavorite;

    private int compte = 1;

    private static CacheManager instance = null;

    private CacheManager() {
        pointDEau = new PointDEau();
        pointDEauFavorite = new PointDEau();
    }



    public static CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public PointDEau getPointDEau() {
        return pointDEau;
    }

    public void setPointDEau(PointDEau pointDEau) {
        this.pointDEau = pointDEau;
    }

    public PointDEau getPointDEauFavorite() {
        return pointDEauFavorite;
    }

    public void setPointDEauFavorite(PointDEau pointDEauFavorite) {
        this.pointDEauFavorite = pointDEauFavorite;
    }

    public int getCompte() {
        return compte;
    }

    public void setCompte(int compte) {
        this.compte = compte;
    }

    public void addCompte() {
        this.compte++;
    }

    public Boolean getDark() {
        return isDark;
    }

    public void setDark(Boolean dark) {
        isDark = dark;
    }




}
