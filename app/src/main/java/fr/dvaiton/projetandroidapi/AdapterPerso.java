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

import fr.dvaiton.projetandroidapi.Manager.CacheManager;
import fr.dvaiton.projetandroidapi.Model.PointDEau;
import fr.dvaiton.projetandroidapi.Model.Records;

public class AdapterPerso extends RecyclerView.Adapter<AdapterPerso.MyViewHolder>{

    Context context;

    ArrayList<Records> pointDEauArrayList;







    public AdapterPerso(Context context , ArrayList<Records> pointDEauArrayList) {
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
        holder.Nom.setText(pointDEauArrayList.get(position).getFields().getCommune());
        holder.Type.setText(pointDEauArrayList.get(position).getFields().getDepName());
        holder.Commune.setText(pointDEauArrayList.get(position).getFields().getNature());
    }

    @Override
    public int getItemCount() {
        return pointDEauArrayList.size();
    }








    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


        TextView Nom,Type,Commune;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Nom = itemView.findViewById(R.id.nomPoint);
            Type = itemView.findViewById(R.id.typeEau);
            Commune = itemView.findViewById(R.id.NomCommune);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);




        }

        @Override
        public void onClick(View v) {

            androidx.appcompat.app.AlertDialog.Builder pop = new AlertDialog.Builder(v.getContext());
            pop.setTitle("Info point" );

            pop.setMessage("Code INSEE: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getCodeInsee()
                    + "\n ID: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getId()
                    + "\n Commmune: "+pointDEauArrayList.get(getAdapterPosition()).getFields().getCommune()
                    + "\n Departement: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getDepName()
                    + "\n Type de point d'eau: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getNature()
                    + "\n Latitude: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getGeoShape().getLatitude()
                    + "\n Longitude: " + pointDEauArrayList.get(getAdapterPosition()).getFields().getGeoShape().getLongitude())
                    ;


            pop.show();


        }


        @Override
        public boolean onLongClick(View v) {
            CacheManager cacheManager = CacheManager.getInstance();
            ArrayList<Records> list = cacheManager.getPointDEauFavorite().getRecords();
            list.add(pointDEauArrayList.get(getAdapterPosition()));


            Log.e("test", "onLongClick: " + list.size());

            return true;
        }
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
        boolean onItemLongClick(View view, int position);
    }
}



