package com.example.danilo.multasdetransito;

/**
 * Created by Danilo on 27/05/2017.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private String multa;
    private String tipoMulta;
    private String foto;


    public Carro(String foto, String placa, String marca, String modelo, String multa, String tipoMulta) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.multa = multa;
        this.tipoMulta = tipoMulta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }


    public String getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(String tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public String getFoto() {

        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void guardar (Context contexto){

        SQLiteDatabase db;
        String sql;


        CarroSQLiteOpenHelper aux = new CarroSQLiteOpenHelper(contexto,"DBCarros",null,1);
        db= aux.getWritableDatabase();

        sql = "INSERT INTO Carros values ('"+this.getFoto()+"','"
                +this.getPlaca()+"','"
                +this.getMarca()+"','"
                +this.getModelo()+"','"
                +this.getMulta()+"','"
                +this.getTipoMulta()+"')";

        db.execSQL(sql);
        db.close();;


    }
    public void eliminar (Context contexto){

        SQLiteDatabase db;
        String sql;

        CarroSQLiteOpenHelper aux = new CarroSQLiteOpenHelper(contexto,"DBCarros",null,1);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM Carros where placa ='"+this.getPlaca()+"'";
        db.execSQL(sql);
        db.close();



    }



}
