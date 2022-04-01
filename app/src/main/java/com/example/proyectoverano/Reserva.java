package com.example.proyectoverano;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reserva extends AppCompatActivity implements View.OnClickListener {
    EditText etReserva;
    Button btnReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        etReserva = findViewById(R.id.etReserva);
        btnReserva = findViewById(R.id.btnReserva);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Reserva.this);
        String nombreReserva=prefs.getString("nombreReserva", "");

        etReserva.setText(nombreReserva);


        btnReserva.setOnClickListener(this);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Reserva.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombreReserva", etReserva.getText().toString());

        editor.apply();

        super.onSaveInstanceState(outState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnReserva) {
            Intent i = new Intent();
            if (etReserva.getText().toString().isEmpty()) {
                Toast.makeText(this, "El campo necesario para hacer la reserva está vacío.", Toast.LENGTH_SHORT).show();
                etReserva.setHintTextColor(getResources().getColor(R.color.colorRojo));
                etReserva.getBackground().setTint(ContextCompat.getColor(this, R.color.colorRojo));
            }
            i = new Intent(this, Pedido.class);
            i.putExtra("nombreReserva", etReserva.getText().toString());
            startActivity(i);

        }

    }
}