package com.fontanalautaro.mimascotasemana3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fontanalautaro.mimascotasemana3.R;
import com.fontanalautaro.mimascotasemana3.adapter.MascotaAdaptador;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment   {

    private RecyclerView rvMascotas;
    private MascotaAdaptador adaptador;
    private ArrayList<Mascota> mascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        //Crear mi recyclerview , y asignarle un un Administrador de layout
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        rvMascotas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);



        //Inicializar lista de mascotas
        inicializarListaMascotas();

        //Inicializar adaptador
        inicializarAdaptador();


        return v;
    }

    public void inicializarListaMascotas(){
        //Por ahora hardcodeamos la lista con mascotas agregadas por nosotros

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.imagen_perro_2,"Coco",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro_3,"Kiwi",3));
        mascotas.add(new Mascota(R.drawable.imagen_perro_4,"Lua",7));
        mascotas.add(new Mascota(R.drawable.imagen_perro_5,"Lali",10));
        mascotas.add(new Mascota(R.drawable.imagen_perro_6,"Sam",5));
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);

    }
}
