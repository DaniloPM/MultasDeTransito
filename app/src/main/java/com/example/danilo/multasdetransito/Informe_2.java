package com.example.danilo.multasdetransito;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Informe_2 extends AppCompatActivity {

    private ArrayList<Carro> carroArrayList;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_2);


        ListView listaCarros = (ListView)findViewById(R.id.lsRporteMultaPorAlcohol);
        ArrayList<Carro> carros=Datos.traerCarros(getApplicationContext());

        AdaptadorInforme adaptadorInforme = new AdaptadorInforme(getApplicationContext(),carros, getResources().getString(R.string.estado_de_embriagues));
        listaCarros.setAdapter(adaptadorInforme);


    }

}
