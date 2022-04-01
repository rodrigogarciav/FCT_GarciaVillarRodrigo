package com.example.BBDD;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Plato {

    @PrimaryKey
    @NonNull
    private String nombrePlato;
    private String posicion;
    private float precio;

    public Plato() {
    }

    public Plato(String nombrePlato, String posicion, float precio) {
        this.nombrePlato = nombrePlato;
        this.posicion = posicion;
        this.precio = precio;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
