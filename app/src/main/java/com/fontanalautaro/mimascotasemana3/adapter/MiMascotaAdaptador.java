package com.fontanalautaro.mimascotasemana3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fontanalautaro.mimascotasemana3.R;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;

public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MiMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    //Inflar layout y lo pasara al viewholder para que el obtenga los views
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    //asocia cada elemento de nuestra vista con cada view
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;

        private TextView tvLikesCV;



        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);

            tvLikesCV = (TextView) itemView.findViewById(R.id.tvLikesCV);




        }
    }
}
