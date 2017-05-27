package com.example.danilo.multasdetransito;

/**
 * Created by Danilo on 27/05/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Danilo on 25/05/2017.
 */

public class AdaptadorInforme extends BaseAdapter {

    private Context contexto;
    private ArrayList<Carro> carros;
    private String velocidad;

    public AdaptadorInforme(Context contexto, ArrayList<Carro> carros, String velocidad) {
        this.contexto = contexto;
        this.carros = carros;
        this.velocidad = velocidad;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView placa, marca, modelo, multa, tipoMulta;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;


        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_carro,null);

        placa = (TextView)itemView.findViewById(R.id.txtPlaca);
        marca = (TextView)itemView.findViewById(R.id.txtMarca);
        modelo = (TextView)itemView.findViewById(R.id.txtModelo);
        multa = (TextView)itemView.findViewById(R.id.txtMulta);
        tipoMulta = (TextView)itemView.findViewById(R.id.txtTipoMulta);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        if (carros.get(position).getTipoMulta().equalsIgnoreCase(velocidad)){
            placa.setText(carros.get(position).getPlaca());
            marca.setText(carros.get(position).getMarca());
            modelo.setText(carros.get(position).getModelo());
            multa.setText(carros.get(position).getMulta());
            tipoMulta.setText(carros.get(position).getTipoMulta());
            foto.setImageResource(Integer.parseInt(carros.get(position).getFoto()));
        }

        return  itemView;

    }
}