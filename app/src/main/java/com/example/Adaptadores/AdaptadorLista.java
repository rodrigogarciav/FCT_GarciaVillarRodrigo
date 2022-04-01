package com.example.Adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.BBDD.Plato;
import com.example.proyectoverano.R;

import java.util.ArrayList;

public class AdaptadorLista extends ArrayAdapter<Plato> {
    private Activity context;
    private ArrayList<Plato> plato;
    private TypedArray arrayFotos;

    public AdaptadorLista(@NonNull Activity context, ArrayList<Plato> plato, TypedArray arrayFotos) {
        super(context, R.layout.activity_adaptador_lista, plato);
        this.context = context;
        this.plato = plato;
        this.arrayFotos = arrayFotos;
    }


    public AdaptadorLista(@NonNull Activity context, ArrayList<Plato> plato) {
        super(context, R.layout.activity_adaptador_lista, plato);
        this.context = context;
        this.plato = plato;
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;
        ViewHolder viewHolder;

        if (fila == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            fila = layoutInflater.inflate(R.layout.activity_adaptador_lista, null);
            viewHolder = new ViewHolder();
            viewHolder.txtNombrePlato = fila.findViewById(R.id.txtNombrePlato);
            viewHolder.txtPrecio = fila.findViewById(R.id.txtPrecio);
            viewHolder.txtPosicion = fila.findViewById(R.id.txtPosicion);
            viewHolder.imgPlato = fila.findViewById(R.id.imgPlato);
            fila.setTag(viewHolder);


            viewHolder.txtNombrePlato.setTextColor(context.getResources().getColor(R.color.colorBlanco));
            viewHolder.txtNombrePlato.setBackgroundColor(context.getResources().getColor(R.color.colorAzul));
            viewHolder.txtPosicion.setTextColor(context.getResources().getColor(R.color.colorBlanco));
            viewHolder.txtPrecio.setBackgroundColor(context.getResources().getColor(R.color.colorBlanco));
            viewHolder.txtPrecio.setTextColor(context.getResources().getColor(R.color.colorAzul));
            viewHolder.txtNombrePlato.setTextSize(25);
            viewHolder.txtPrecio.setTextSize(15);
            viewHolder.txtPosicion.setTextSize(15);

            Plato p = plato.get(position);

            viewHolder.txtNombrePlato.setText(p.getNombrePlato());
            viewHolder.txtPrecio.setText(p.getPrecio() + "");
            viewHolder.txtPosicion.setText(p.getPosicion());




        } else {
            viewHolder = (ViewHolder) fila.getTag();
        }

        return fila;
    }


    private static class ViewHolder {
        TextView txtNombrePlato;
        TextView txtPrecio;
        TextView txtPosicion;
        ImageView imgPlato;
    }

}