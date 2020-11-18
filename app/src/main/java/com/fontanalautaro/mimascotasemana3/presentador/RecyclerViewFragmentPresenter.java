package com.fontanalautaro.mimascotasemana3.presentador;

import android.content.Context;

import com.fontanalautaro.mimascotasemana3.adapter.MascotaAdaptador;
import com.fontanalautaro.mimascotasemana3.db.ConstructorMascotas;
import com.fontanalautaro.mimascotasemana3.fragment.IRecyclerViewFragmentView;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView IRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView IRecyclerViewFragmentView, Context context) {
        this.IRecyclerViewFragmentView = IRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        IRecyclerViewFragmentView.inicializarAdaptadorRV(IRecyclerViewFragmentView.crearAdaptador(mascotas));
        IRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
