package fr.dvaiton.projetandroidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Manager.ApiManager;
import fr.dvaiton.projetandroidapi.Manager.MainActivityController;
import fr.dvaiton.projetandroidapi.Manager.PointDEauDataManagerCallback;
import fr.dvaiton.projetandroidapi.Model.Fields;
import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class MainActivity extends AppCompatActivity implements PointDEauDataManagerCallback {


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





        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        activityController.loadEau(this);


        adapter.notifyDataSetChanged();






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