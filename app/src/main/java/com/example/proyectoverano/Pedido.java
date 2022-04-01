package com.example.proyectoverano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class Pedido extends AppCompatActivity implements View.OnClickListener {
    TextView txtPedidoNombre;
    Button btnPedir, btnBebida, btnEntrantes, btnPrimero, btnSegundo, btnPostre;
    AutoCompleteTextView ACTVBebida, ACTVEntrantes, ACTVPrimero, ACTVSegundo, ACTVPostre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        txtPedidoNombre = findViewById(R.id.txtPedidoNombre);
        btnBebida = findViewById(R.id.btnBebida);
        btnEntrantes = findViewById(R.id.btnEntrantes);
        btnPrimero = findViewById(R.id.btnPrimero);
        btnSegundo = findViewById(R.id.btnSegundo);
        btnPostre = findViewById(R.id.btnPostre);
        btnPedir = findViewById(R.id.btnPedir);
        ACTVBebida = findViewById(R.id.ACTVBebida);
        ACTVEntrantes = findViewById(R.id.ACTVEntrantes);
        ACTVPrimero = findViewById(R.id.ACTVPrimero);
        ACTVSegundo = findViewById(R.id.ACTVSegundo);
        ACTVPostre = findViewById(R.id.ACTVPostre);

        btnBebida.setOnClickListener(this);
        btnPrimero.setOnClickListener(this);
        btnEntrantes.setOnClickListener(this);
        btnSegundo.setOnClickListener(this);
        btnPostre.setOnClickListener(this);
        btnPedir.setOnClickListener(this);

        Intent i = getIntent();
        if (i.getStringExtra("nombreReserva") != null) {
            txtPedidoNombre.setText("Pedido de: " + i.getStringExtra("nombreReserva"));
        }
    }

    @Override
    public void onClick(View v) {

    }
}