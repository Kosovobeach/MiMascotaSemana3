package com.fontanalautaro.mimascotasemana3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fontanalautaro.mimascotasemana3.R;

import com.fontanalautaro.mimascotasemana3.adapter.MiMascotaAdaptador;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    private RecyclerView rvMiMascota;
    private MiMascotaAdaptador adaptador;
    private ArrayList<Mascota> mascotas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Crear mi recyclerview , y asignarle un un Administrador de layout
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        rvMiMascota.setHasFixedSize(true);
        //LinearLayoutManager llm = new LinearLayoutManager(getContext());
        GridLayoutManager llm = new GridLayoutManager(getContext(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMiMascota.setLayoutManager(llm);



        //Inicializar lista de mascotas
        inicializarListaMascotas();

        //Inicializar adaptador
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){
        //Por ahora hardcodeamos la lista con mascotas agregadas por nosotros

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",2));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",10));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",7));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",2));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",10));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",7));
    }

    public void inicializarAdaptador(){
        adaptador = new MiMascotaAdaptador(mascotas, getActivity());
        rvMiMascota.setAdapter(adaptador);

    }
}