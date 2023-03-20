package fr.dvaiton.projetandroidapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Records {

    @SerializedName("datasetid")
    @Expose
    private String datasetid;

    @SerializedName("recordid")
    @Expose
    private String records;

    private Fields fields;

    public String getRecords() {
        return records;
    }

    public Fields getFields(){
        return fields;
    }


    public CharSequence affiche(){
        return "ID: " +  fields.getId() + "\n Departement: " + fields.getDepName()  + fields.getCommune() + "\n Region "+fields.getRegName();
    }


}
