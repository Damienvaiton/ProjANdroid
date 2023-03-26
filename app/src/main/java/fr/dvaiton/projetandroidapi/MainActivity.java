package fr.dvaiton.projetandroidapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Manager.ApiManager;
import fr.dvaiton.projetandroidapi.Manager.CacheManager;
import fr.dvaiton.projetandroidapi.Manager.MainActivityController;
import fr.dvaiton.projetandroidapi.Manager.PointDEauDataManagerCallback;
import fr.dvaiton.projetandroidapi.Model.Fields;
import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class MainActivity extends AppCompatActivity implements PointDEauDataManagerCallback {




   private EndlessRecyclerViewScrollListener scrollListener;


    Button button,btncharge;

    ArrayList<PointDEau> listPoints;

    MainActivityController activityController;

    AdapterPerso adapter;


    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        activityController = new MainActivityController();


        CacheManager cacheManager = CacheManager.getInstance();

        cacheManager.setCompte(1);



        listPoints = new ArrayList<>();
        adapter = new AdapterPerso(this,listPoints);
        recyclerView = findViewById(R.id.Vuedatas);
        button = findViewById(R.id.CarteButton);
        btncharge = findViewById(R.id.charge);

        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);



        recyclerView.setLayoutManager(linearLayoutManagers);
        recyclerView.setAdapter(adapter);




        if (isNetworkAvailable(getApplicationContext())) {
            activityController.loadEau(this,1);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Erreur de connexion");
            builder.setMessage("Veuillez vérifier votre connexion internet");
            builder.setPositiveButton("OK", (dialog, which) -> {
                dialog.dismiss();
                finish();
            });
            builder.show();
        }






        adapter.notifyDataSetChanged();




        button.setOnClickListener(v -> {
            Intent maps = new Intent(MainActivity.this,MapsActivity.class);


            Log.e("sizearray",listPoints.get(0).getRecords().size()+"");

            startActivity(maps);








        }
        );

        btncharge.setOnClickListener(v -> {
            cacheManager.addCompte();
            Log.e("Errorcompte",cacheManager.getCompte()+"");
            activityController.loadEau(MainActivity.this, cacheManager.getCompte());
            Log.e("Error",listPoints.size()+"");




        });

/*
        scrollListener = new EndlessRecyclerViewScrollListener((linearLayoutManagers)) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.e("Error","Fin de la liste");
                cacheManager.addCompte();
                Log.e("Errorcompte",cacheManager.getCompte()+"");

                activityController.loadEau(MainActivity.this, cacheManager.getCompte());
                adapter.notifyDataSetChanged();
            }
        };


        recyclerView.addOnScrollListener(scrollListener);


*/





    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void getTimeResponseSuccess(PointDEau pointdeau) {
        listPoints.add(pointdeau);
        CacheManager cacheManager = CacheManager.getInstance();
        cacheManager.setPointDEau(pointdeau);



        adapter.notifyDataSetChanged();
        Log.e("Error","Fin de la requete");
    }

    @Override
    public void getTimeResponseError(String error) {

    }


}



