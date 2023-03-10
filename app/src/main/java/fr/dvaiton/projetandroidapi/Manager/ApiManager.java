package fr.dvaiton.projetandroidapi.Manager;

public class ApiManager {

    final String BASE_URL = "hhttps://public.opendatasoft.com/api/records/1.0/search/?dataset=hydrographie-points-deau-en-france&q=&facet=nature&facet=commune";

    private static ApiManager instance;

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }

        return instance;
    }

    private ApiManager() {

    }







}


