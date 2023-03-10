package fr.dvaiton.projetandroidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class MainActivity extends AppCompatActivity {



    ArrayList<PointDEau> pointDEauArrayList;

    AdapterPerso adapter;

    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointDEauArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.Vuedatas);


        adapter = new AdapterPerso(this, pointDEauArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();




    }
}