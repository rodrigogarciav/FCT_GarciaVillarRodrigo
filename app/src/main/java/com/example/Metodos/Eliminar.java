package com.example.Metodos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.BBDD.DBPlato;
import com.example.BBDD.Plato;
import com.example.proyectoverano.R;

import java.util.List;

public class Eliminar extends AppCompatActivity implements View.OnClickListener {
    private AutoCompleteTextView ACTVNombre;
    public DBPlato dbp = DBPlato.getDatabase(this);
    private List<Plato> platos;
    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        ACTVNombre = findViewById(R.id.ACTVNombre);
        btnEliminar = findViewById(R.id.btnEliminar);

        btnEliminar.setOnClickListener(this);

         platos = dbp.platoDAO().obtenerPlatos();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, platos);
        ACTVNombre.setAdapter(adapter);

        }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnEliminar) {
            Plato plato = dbp.platoDAO().obtenerPlatosPorNombre( ACTVNombre.getText().toString());
            if (plato == null) {
                Toast.makeText(this, "Este plato no existe.", Toast.LENGTH_SHORT).show();
            } else {
                dbp.platoDAO().eliminar(plato);
                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, platos);
                ACTVNombre.setAdapter(adapter);
                Toast.makeText(this, R.string.PlatoEliminado, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
