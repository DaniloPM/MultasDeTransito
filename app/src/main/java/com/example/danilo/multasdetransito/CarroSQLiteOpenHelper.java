package com.example.danilo.multasdetransito;

/**
 * Created by Danilo on 27/05/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Danilo on 25/05/2017.
 */

public class CarroSQLiteOpenHelper extends SQLiteOpenHelper {

    private String sql = " CREATE TABLE Carros(placa text,marca text, modelo text, multa text, tipoMulta text, foto text )";

    public CarroSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE EXISTS Carros");
        db.execSQL(sql);
    }
}
