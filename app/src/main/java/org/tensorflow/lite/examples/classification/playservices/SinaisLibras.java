package org.tensorflow.lite.examples.classification.playservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.sql.SQLOutput;

public class SinaisLibras extends AppCompatActivity {
    private static String sinal="",predict="";
    PredictText predictText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_libras);
       // Intent volto = getIntent();
       // String resultado =volto.getStringExtra("predict");
        sinal=predictText.getSinal();
        predict=predictText.getPredicttext();
        if(predict!= null){
            if(sinal.toUpperCase().equals(predict.toUpperCase())){
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resu5ltado da Atividade");
                janela.setMessage("Parabens vc Acertou!!!!!\n vc Fez a Letra: " + predict);
                janela.setNeutralButton("OK",null);
                janela.show();
            }else{
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resul5tado da Atividade");
                janela.setMessage("Vc deveria fazer a letra: "+sinal+"\n vc Fez a Letra: " + predict +" \nLetra Incorreta Por Favor Refaça");
                janela.setNeutralButton("OK",null);
                janela.show();
            }
        }
    }
    public void onclick(View button){
        predictText.setSinal(button.getTag().toString());
        Intent i = new Intent(SinaisLibras.this,CameraActivity.class);
        //i.putExtra("desejado",sinal);
        startActivity(i);
    }
}