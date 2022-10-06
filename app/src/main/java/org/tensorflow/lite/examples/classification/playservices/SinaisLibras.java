package org.tensorflow.lite.examples.classification.playservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.SQLOutput;

public class SinaisLibras extends AppCompatActivity {
    private static String sinal="";
    private static int cont=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_libras);
        Intent volto = getIntent();
        if(volto.getStringExtra("predict") != null){
            String resultado =volto.getStringExtra("predict");
            //String desejado = volto.getStringExtra("desejado2");
            if(sinal.toUpperCase().equals(resultado.toUpperCase())){
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Parabens vc Acertou!!!!!\n vc Fez a Letra: " + resultado+"\nVezes "+cont);
                janela.setNeutralButton("OK",null);
                janela.show();
                sinal="";
            }else{
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Vc deveria fazer a letra: "+sinal+"\n vc Fez a Letra: " + resultado +" \nLetra Incorreta Por Favor Refaça"+"\nVezes "+cont);
                janela.setNeutralButton("OK",null);
                janela.show();
                sinal="";
            }
        }
    }
    public void onclick(View button){
        sinal= button.getTag().toString();
        cont=cont+1;
        Intent i = new Intent(SinaisLibras.this,CameraActivity.class);
        i.putExtra("desejado",sinal);
        startActivity(i);
    }
}