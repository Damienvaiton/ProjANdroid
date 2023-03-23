package fr.dvaiton.projetandroidapi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.dvaiton.projetandroidapi.Model.PointDEau;

public class AdapterPerso extends RecyclerView.Adapter<AdapterPerso.MyViewHolder>{

    Context context;

    ArrayList<PointDEau> pointDEauArrayList;







    public AdapterPerso(Context context , ArrayList<PointDEau> pointDEauArrayList) {
        this.context = context;
        this.pointDEauArrayList = pointDEauArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.pointeau, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Nom.setText(pointDEauArrayList.get(position).getRecords().get(position).getFields().getCommune());
        holder.Type.setText(pointDEauArrayList.get(position).getRecords().get(position).getFields().getDepName());
        holder.Commune.setText(pointDEauArrayList.get(position).getRecords().get(position).getFields().getNature());
    }

    @Override
    public int getItemCount() {
        return pointDEauArrayList.size();
    }








    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView Nom,Type,Commune;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Nom = itemView.findViewById(R.id.nomPoint);
            Type = itemView.findViewById(R.id.typeEau);
            Commune = itemView.findViewById(R.id.NomCommune);
            itemView.setOnClickListener(this);




        }

        @Override
        public void onClick(View v) {
            androidx.appcompat.app.AlertDialog.Builder pop = new AlertDialog.Builder(v.getContext());
            pop.setTitle("Info point" );

            pop.setMessage("Code INSEE: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getCodeInsee()
                    + "\n ID: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getId()
                    + "\n Commmune: "+pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getCommune()
                    + "\n Departement: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getDepName()
                    + "\n Type de point d'eau: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getNature()
                    + "\n Latitude: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getGeoShape().getLatitude()
                    + "\n Longitude: " + pointDEauArrayList.get(getAdapterPosition()).getRecords().get(getAdapterPosition()).getFields().getGeoShape().getLongitude())
                    ;


            pop.show();


        }


    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
        boolean onItemLongClick(View view, int position);
    }
}



