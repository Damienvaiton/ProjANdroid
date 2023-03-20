package fr.dvaiton.projetandroidapi.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoShape {

    @SerializedName("coordinates")
    @Expose
    private List<Double> coordinates;
    @SerializedName("type")
    @Expose
    private String type;

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLatitude(){
        return coordinates.get(0);
    }

    public Double getLongitude(){
        return coordinates.get(1);
    }


}