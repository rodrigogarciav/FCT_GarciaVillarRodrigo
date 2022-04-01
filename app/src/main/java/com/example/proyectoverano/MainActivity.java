package com.example.proyectoverano;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String geoLocation = "geo:42.280399, -8.736856?z=20";
    Button btnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcceder = findViewById(R.id.btnAcceder);

        btnAcceder.setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.opcValoracion:
                Intent i; //= new Intent(this, );
                //startActivity(i);
                return true;

            case R.id.opcFinalizar:
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setIcon(R.drawable.cuchilleria);
                ventana.setTitle(R.string.Mensaje1);
                ventana.setMessage(getString(R.string.Mensaje2) + "\n" + getString(R.string.Mensaje3));
                ventana.setCancelable(false);
                ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                });
                ventana.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ventana.show();
                return true;

            case R.id.opcUbicacion:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(geoLocation));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }

                return true;

            case R.id.opcContacto:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?sa=X&rlz=1C1VDKB_esES947ES947&q=restaurante+moa%C3%B1a&ved=2ahUKEwif5p69lPP2AhUJLBoKHd58DQ8QuzF6BAgBEAI&biw=1920&bih=937&dpr=1"));
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnAcceder) {
            Intent i = new Intent (this, Login.class);
            startActivity(i);
        }
    }
}