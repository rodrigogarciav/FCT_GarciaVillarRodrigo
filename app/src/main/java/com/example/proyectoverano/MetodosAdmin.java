package com.example.proyectoverano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Metodos.Crear;
import com.example.Metodos.Eliminar;
import com.example.Metodos.Modificar;

public class MetodosAdmin extends AppCompatActivity implements View.OnClickListener {

    Button btnAñadir, btnEliminar, btnModificar, btnVerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_admin);
        btnAñadir = findViewById(R.id.btnAñadir);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnModificar = findViewById(R.id.btnModificar);
        btnVerLista = findViewById(R.id.btnVerLista);

        btnAñadir.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        btnVerLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        if (v.getId()==R.id.btnAñadir) {
            i = new Intent(this, Crear.class);
            startActivity(i);
        } else if (v.getId()==R.id.btnEliminar) {
            i = new Intent(this, Eliminar.class);
            startActivity(i);
        } else if (v.getId()==R.id.btnModificar) {
            i = new Intent(this, Modificar.class);
            startActivity(i);
        } else if (v.getId()==R.id.btnVerLista) {
            i = new Intent(this, ListaMenuComida.class);
            startActivity(i);
        }
    }
}