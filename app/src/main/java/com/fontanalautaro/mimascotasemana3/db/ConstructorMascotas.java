package com.fontanalautaro.mimascotasemana3.db;

import android.content.ContentValues;
import android.content.Context;

import com.fontanalautaro.mimascotasemana3.R;
import com.fontanalautaro.mimascotasemana3.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final Integer LIKE = 1;

    //Esta es la clase que interactua con la base de datos

    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    //No importa de donde yo obtenga los datos, siempre venir en un arraylist

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);

        //insertarTresMascotas(db);
        return db.obtenerTodosLasMascotas();

    }

    public void insertarTresMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Coco");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.imagen_perro_2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Kiwi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.imagen_perro_3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Lua");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.imagen_perro_4);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascotas (Mascota mascota){
        BaseDatos db = new BaseDatos(context);

        return db.obtenerLikesMascota(mascota);
    }
}
