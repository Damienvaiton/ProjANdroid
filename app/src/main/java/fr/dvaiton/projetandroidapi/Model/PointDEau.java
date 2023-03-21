package fr.dvaiton.projetandroidapi.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class PointDEau implements Serializable {


    @SerializedName("nhits")
    @Expose
    private int nbentrée;

   private ArrayList<Records> records;



    public ArrayList<Records> getRecords() {
        return records;
    }

    public String affiche(int i){
        return "ID: " +  records.get(i).getFields().getId() + "\n Departement: " + records.get(i).getFields().getDepName()  + records.get(i).getFields().getCommune() + "\n Region "+records.get(i).getFields().getRegName();
    }


}