package fr.dvaiton.projetandroidapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPerso extends RecyclerView.Adapter<AdapterPerso.MyViewHolder>{

    Context context;

    ArrayList<PointDEau> pointDEauArrayList;





    public AdapterPerso(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.pointeau, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.Nom.setText("Nom");
        holder.Type.setText("Type");
        holder.Commune.setText("Commune");
    }

    @Override
    public int getItemCount() {
        return 0;
    }








    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Nom,Type,Commune;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Nom = itemView.findViewById(R.id.nomPoint);
            Type = itemView.findViewById(R.id.typeEau);
            Commune = itemView.findViewById(R.id.NomCommune);



        }
    }
}



