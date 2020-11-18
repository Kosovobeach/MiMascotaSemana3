package com.fontanalautaro.mimascotasemana3.fragment;

import com.fontanalautaro.mimascotasemana3.adapter.MascotaAdaptador;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (MascotaAdaptador adaptador);
}
