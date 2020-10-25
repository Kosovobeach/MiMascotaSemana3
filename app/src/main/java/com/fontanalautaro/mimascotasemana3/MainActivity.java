package com.fontanalautaro.mimascotasemana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMascotas;
    public MascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Incluir mi action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);






        //Crear mi recyclerview , y asignarle un un Administrador de layout
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        //Inicializar lista de mascotas
        inicializarListaMascotas();

        //Inicializar adaptador
        inicializarAdaptador();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater miMenuInflater = getMenuInflater();
        miMenuInflater.inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.icono_estrella:
                Toast.makeText(this, "Entrando al Top 5",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Ranking.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarListaMascotas(){
        //Por ahora hardcodeamos la lista con mascotas agregadas por nosotros

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
        mascotas.add(new Mascota(R.drawable.imagen_perro,"Dylan",5));
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);

    }
}