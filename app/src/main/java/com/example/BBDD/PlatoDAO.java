package com.example.BBDD;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.BBDD.Plato;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PlatoDAO {
    @Insert
    void insertar(Plato plato);
    @Delete
    void eliminar (Plato plato);
    @Update
    void actualizar (Plato plato);

    @Query("SELECT * FROM plato")
    List<Plato> obtenerPlatos();

    @Query("SELECT * FROM plato WHERE nombrePlato  = :nombre")
    Plato obtenerPlatosPorNombre(String nombre);

    @Query("SELECT count(*) FROM plato")
    int contarPlatos();
}
