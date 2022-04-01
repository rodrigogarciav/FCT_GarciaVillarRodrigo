package com.example.Metodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.BBDD.DBPlato;
import com.example.BBDD.Plato;
import com.example.BBDD.PlatoDAO;
import com.example.proyectoverano.R;

public class Crear extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre, etPrecio;
    private Button btnAñadir;
    private Spinner spPosicion;
    public DBPlato dbp = DBPlato.getDatabase(this);
    private int eleccion;
    public static int MILISEGUNDOS_ESPERA = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        etNombre = findViewById(R.id.etNombre);
        etPrecio = findViewById(R.id.etPrecio);
        spPosicion = findViewById(R.id.spPosicion);
        btnAñadir = findViewById(R.id.btnAñadir);

        btnAñadir.setOnClickListener(this);

        String[] arraySpinnerPosiciones = getResources().getStringArray(R.array.SPINNER_POSICIONES);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arraySpinnerPosiciones);

        spPosicion.setAdapter(adaptador);

        spPosicion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                eleccion = (int) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, milisegundos);
    }

    Plato plato = new Plato(etNombre.getText().toString(), spPosicion.getItemAtPosition(eleccion).toString(), Float.parseFloat(etPrecio.getText().toString()));

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAñadir) {
            dbp.platoDAO().insertar(plato);
            Toast.makeText(this, R.string.PlatoCreado, Toast.LENGTH_SHORT).show();
            esperarYCerrar(MILISEGUNDOS_ESPERA);
        }


    }
}