package com.example.danilo.multasdetransito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {
    private ArrayList<Carro> carroArrayList;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        ListView listaCarros = (ListView)findViewById(R.id.listCarros);
        ArrayList<Carro> carros=Datos.traerCarros(getApplicationContext());

        AdaptadorCarro AdaptadorCarro = new AdaptadorCarro(getApplicationContext(),carros);
        listaCarros.setAdapter(AdaptadorCarro);
    }


}
