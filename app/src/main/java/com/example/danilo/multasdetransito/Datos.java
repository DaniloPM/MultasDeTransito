package com.example.danilo.multasdetransito;

/**
 * Created by Danilo on 27/05/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carro> traerCarros(Context contexto){
        ArrayList<Carro> carros = new ArrayList<>();

        String sql,foto,placa,marca,modelo,multa,tipoMulta;

        SQLiteDatabase db;
        Carro cr;

        CarroSQLiteOpenHelper aux = new CarroSQLiteOpenHelper(contexto,"DBCarros",null,1);

        db = aux.getReadableDatabase();

        sql = "select * from Carros";
        Cursor c = db.rawQuery(sql,null);

        if ( c.moveToFirst()){

            do{
                foto = c.getString(0);
                placa = c.getString(1);
                marca = c.getString(2);
                modelo = c.getString(3);
                multa= c.getString(4);
                tipoMulta= c.getString(5);

                cr = new Carro(foto,placa,marca,modelo,multa,tipoMulta);
                carros.add(cr);


            } while (c.moveToNext());
        }

        db.close();
        return carros;

    }









}
