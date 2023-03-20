package fr.dvaiton.projetandroidapi.Manager;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public interface PointDEauDataManagerCallback {
    void getTimeResponseSuccess(PointDEau pointdeau);
    void getTimeResponseError(String error);
}
