package fr.dvaiton.projetandroidapi.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;



public class Fields {

    @SerializedName("reg_name")
    private String regName;
    @SerializedName("id")
    private String id;
    @SerializedName("dep_name")
    private String depName;
    @SerializedName("geo_point_2d")
    private List<Double> geoPoint2d;
    @SerializedName("geo_shape")
    private GeoShape geoShape;
    @SerializedName("commune")
    private String commune;
    @SerializedName("nature")
    private String nature;

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Double> getGeoPoint2d() {
        return geoPoint2d;
    }

    public void setGeoPoint2d(List<Double> geoPoint2d) {
        this.geoPoint2d = geoPoint2d;
    }

    public GeoShape getGeoShape() {
        return geoShape;
    }

    public void setGeoShape(GeoShape geoShape) {
        this.geoShape = geoShape;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }




}