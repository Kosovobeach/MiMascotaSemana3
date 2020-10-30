package com.fontanalautaro.mimascotasemana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

public class BioDesarrollador extends AppCompatActivity {

    ImageView fotoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_desarrollador);

        //Incluir mi action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fotoPerfil = (ImageView) findViewById(R.id.ivFotoPerfil);
        fotoPerfil.setImageResource(R.drawable.icono_persona);

    }
}