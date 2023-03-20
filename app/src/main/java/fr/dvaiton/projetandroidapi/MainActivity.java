package fr.dvaiton.projetandroidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Manager.ApiManager;
import fr.dvaiton.projetandroidapi.Manager.MainActivityController;
import fr.dvaiton.projetandroidapi.Manager.PointDEauDataManagerCallback;
import fr.dvaiton.projetandroidapi.Model.Fields;
import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class MainActivity extends AppCompatActivity implements PointDEauDataManagerCallback {


    public static int nbVaribale = 100;

    Button button;

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

        listPoints = new ArrayList<>();
        adapter = new AdapterPerso(this,listPoints);
        recyclerView = findViewById(R.id.Vuedatas);
        button = findViewById(R.id.CarteButton);





        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        activityController.loadEau(this);


        adapter.notifyDataSetChanged();




        button.setOnClickListener(v -> {
            Intent maps = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(maps);



        }
        );



    }


    @Override
    public void getTimeResponseSuccess(PointDEau pointdeau) {

        Log.e("test",listPoints.size()+"");

        listPoints.add(pointdeau);


        Log.e("test",listPoints.size()+"");



        adapter.notifyDataSetChanged();
    }

    @Override
    public void getTimeResponseError(String error) {

    }


}