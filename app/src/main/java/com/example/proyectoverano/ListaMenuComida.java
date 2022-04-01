package com.example.proyectoverano;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.BBDD.DBPlato;
import com.example.BBDD.Plato;

import java.util.ArrayList;

public class ListaMenuComida extends AppCompatActivity implements View.OnClickListener {

    private Button btnPedir;
    private ListView lvCarta;
    public DBPlato dbp = DBPlato.getDatabase(this);

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.lvCarta) {
            getMenuInflater().inflate(R.menu.menu_contextual, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent();
        switch ((item.getItemId())) {
            case R.id.opcReserva:
                i = new Intent(this, Reserva.class);
                startActivity(i);
                return true;

            case R.id.opcLogin:
                i = new Intent(this, Login.class);
                startActivity(i);
                return true;

            case R.id.opcValoracion:
                // i = new Intent(this, .class);
                //  startActivity(i);
                return true;

            default:
                return super.onContextItemSelected(item);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu_comida);
        btnPedir = findViewById(R.id.btnPedir);
        lvCarta = findViewById(R.id.lvCarta);

        final ArrayAdapter<Plato> platos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dbp.platoDAO().obtenerPlatos());
        lvCarta.setAdapter(platos);

        btnPedir.setOnClickListener(this);


        lvCarta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + platos.getItem(position).getNombrePlato()));
                startActivity(i);
            }
        });

        registerForContextMenu(lvCarta);




}

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnPedir) {
            Intent i = new Intent(this, Reserva.class);
            startActivity(i);
        }
    }
}