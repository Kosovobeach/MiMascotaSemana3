package com.fontanalautaro.mimascotasemana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.fontanalautaro.mimascotasemana3.adapter.MascotaAdaptador;
import com.fontanalautaro.mimascotasemana3.adapter.PageAdapter;
import com.fontanalautaro.mimascotasemana3.fragment.PerfilFragment;
import com.fontanalautaro.mimascotasemana3.fragment.RecyclerViewFragment;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_page);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_my_page);
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

                break;
            case R.id.menu_contacto:
                Toast.makeText(this, "Entrando a Contacto",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, FormularioContacto.class);
                startActivity(i);

                break;
            case R.id.menu_acerca_de:
                Toast.makeText(this, "Entrando a bio del desarrolador",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, BioDesarrollador.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}