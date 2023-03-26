package fr.dvaiton.projetandroidapi.Manager;

import android.graphics.Point;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class CacheManager {

    private PointDEau pointDEau;

    private int compte = 1;

    private static CacheManager instance = null;

    private CacheManager() {
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

    public int getCompte() {
        return compte;
    }

    public void setCompte(int compte) {
        this.compte = compte;
    }

    public void addCompte() {
        this.compte++;
    }


}
