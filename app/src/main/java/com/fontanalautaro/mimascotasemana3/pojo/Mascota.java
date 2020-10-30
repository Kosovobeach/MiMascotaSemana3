package com.fontanalautaro.mimascotasemana3.pojo;

public class Mascota {

    //Atributos
    private int foto;
    private String nombre="";
    private int likes=0;

    public Mascota(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
