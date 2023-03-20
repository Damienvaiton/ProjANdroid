package fr.dvaiton.projetandroidapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class PointDEau {


    @SerializedName("nhits")
    @Expose
    private int nbentrée;

   private ArrayList<Records> records;

    public ArrayList<Records> getRecords() {
        return records;
    }












}