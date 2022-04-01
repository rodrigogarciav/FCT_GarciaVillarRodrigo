package com.example.proyectoverano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button btnCliente, btnAdmin, btnAcceder;
    TextView txtTitulo;
    EditText etUsuario, etContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCliente = findViewById(R.id.btnCliente);
        btnAdmin = findViewById(R.id.btnAdmin);
        btnAcceder = findViewById(R.id.btnAcceder);
        txtTitulo = findViewById(R.id.txtTitulo);
        etUsuario = findViewById(R.id.etUsuario);
        etContraseña = findViewById(R.id.etContraseña);

        btnAdmin.setOnClickListener(this);
        btnCliente.setOnClickListener(this);
        btnAcceder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        if (v.getId()==R.id.btnCliente) {
            i = new Intent(this, ListaMenuComida.class);
            startActivity(i);
        } else if (v.getId()==R.id.btnAdmin) {
            btnCliente.setVisibility(View.GONE);
            btnAdmin.setVisibility(View.GONE);
            etContraseña.setVisibility(View.VISIBLE);
            etUsuario.setVisibility(View.VISIBLE);
            btnAcceder.setVisibility(View.VISIBLE);
            if (v.getId()==R.id.btnAcceder) {
                if (etUsuario.getText().toString().isEmpty() || etContraseña.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Alguno de los campos necesarios está vacío.", Toast.LENGTH_SHORT).show();
                } else if (etUsuario.getText().toString().equalsIgnoreCase("administrador") && (etContraseña.getText().toString().equalsIgnoreCase("admin123"))) {
                    i = new Intent(this, MetodosAdmin.class);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Alguno de los campos necesarios es incorrecto.", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}