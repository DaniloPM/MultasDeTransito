package com.example.danilo.multasdetransito;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrarMulta extends AppCompatActivity {

    EditText placa;
    Spinner marca, modelo, multa;
    CheckBox Tipo1,Tipo2,Tipo3;
    Context context;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarmulta);
        context = this;

        Spinner marcaSp = (Spinner) findViewById(R.id.marca_spinner);
        ArrayAdapter<CharSequence> MarcaAdapter = ArrayAdapter.createFromResource(this,
                R.array.marca_spinner, android.R.layout.simple_spinner_item);
        MarcaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marcaSp.setAdapter(MarcaAdapter);

        Spinner modeloSp = (Spinner) findViewById(R.id.modelo_spinner);
        ArrayAdapter<CharSequence> modeloAdapter = ArrayAdapter.createFromResource(this,
                R.array.modelo_spinner, android.R.layout.simple_spinner_item);
        modeloAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeloSp.setAdapter(modeloAdapter);

        Spinner colorSp = (Spinner) findViewById(R.id.Multa_spinner);
        ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(this,
                R.array.Multa_spinner, android.R.layout.simple_spinner_item);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSp.setAdapter(colorAdapter);

        res=this.getResources();
        placa = (EditText)findViewById(R.id.txtPlaca);
        marca = (Spinner)findViewById(R.id.marca_spinner);
        modelo = (Spinner)findViewById(R.id.modelo_spinner);
        multa = (Spinner)findViewById(R.id.Multa_spinner);
        Tipo1 = (CheckBox) findViewById(R.id.chkExcesoVelocidad);
        Tipo2 = (CheckBox) findViewById(R.id.chkEstadoEmbriagues);
        Tipo3 = (CheckBox) findViewById(R.id.chkSinPapeles);

    }

    public void registrar(View v){
        String placaFinal="", evalplaca, TipoMultaFinal, marcaFinal, modeloFinal, multaFinal;
        int fotoFinal;
        int vector [] = {R.drawable.chevrolet, R.drawable.kia, R.drawable.renault,};

        evalplaca = placa.getText().toString().trim();



        if (evalplaca.isEmpty()){
            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                    msjError3Cuerpo).show();
        }else if (evalplaca.length() == 6) {
            Pattern p = Pattern.compile("^[a-zA-Z]*$");
            Matcher m = p.matcher(evalplaca.substring(0,3));
            boolean b = m.matches();
            System.out.println("letra: "+b);
            if (b == true){
                placaFinal = evalplaca.toUpperCase();
            }else{
                new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                        msjError1Cuerpo).show();
                return;
            }

            p = Pattern.compile("^[0-9]*$");
            m = p.matcher(evalplaca.substring(3, 6));
            b = m.matches();

            if (b == true){
                placaFinal.concat(evalplaca.substring(3,6));
            }else{
                new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.
                        msjError2Cuerpo).show();
                return;
            }
            TipoMultaFinal = res.getString(R.string.NoTieneMulta);
            marcaFinal = marca.getSelectedItem().toString();
            modeloFinal = modelo.getSelectedItem().toString();
            multaFinal = multa.getSelectedItem().toString();
            if (Tipo1.isChecked())TipoMultaFinal = res.getString(R.string.exceso_de_velocidad);
            if (Tipo2.isChecked())TipoMultaFinal = res.getString(R.string.estado_de_embriagues);
            if (Tipo3.isChecked())TipoMultaFinal = res.getString(R.string.Sin_Papeles);


            Random rnd = new Random();
            fotoFinal = rnd.nextInt(3-0);


            Carro c = new Carro(String.valueOf(vector[fotoFinal]), placaFinal, marcaFinal, modeloFinal,multaFinal, TipoMultaFinal);
            c.guardar(getApplicationContext());

            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.msjCuerpo).show();

            limpiar(v);
        }else   {
            new AlertDialog.Builder(context).setTitle(R.string.msjTitulo).setMessage(R.string.msjError4Cuerpo).show();
        }
    }

    public void limpiar(View v){
        placa.setText("");
        placa.requestFocus();
        marca.setSelection(0);
        modelo.setSelection(0);
        multa.setSelection(0);
    }


}
