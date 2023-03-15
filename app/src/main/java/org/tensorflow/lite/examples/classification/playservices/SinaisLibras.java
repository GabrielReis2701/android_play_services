package org.tensorflow.lite.examples.classification.playservices;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SinaisLibras extends AppCompatActivity {
    private static String sinal="",predict="";
    PredictText predictText = new PredictText();
    private static final int CAMERA_ACTIVITY_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_libras);
    }
    public void verificar(){
        sinal=predictText.getSinal();
        //predict=predictText.getPrediction();
        if(predict!= "" && predict!=null){
            if(sinal.toUpperCase().equals(predict.toUpperCase())){
                predictText.setSinal("");
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Parabens vc Acertou!!!!!\n vc Fez a Letra: " + predict);
                janela.setNeutralButton("OK",null);
                janela.show();
            }else{
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Vc deveria fazer a letra: "+sinal+"\n vc Fez a Letra: " + predict +" \nLetra Incorreta Por Favor Refaça");
                janela.setNeutralButton("OK",null);
                janela.show();
            }
        }else if(predict.equals("")){
            AlertDialog.Builder janela = new AlertDialog.Builder(this);
            janela.setTitle("Valores Digitados");
            janela.setMessage("Sinal: "+sinal+"\n Predict: " + predict);
            janela.setNeutralButton("OK",null);
            janela.show();
        }else{
            AlertDialog.Builder janela = new AlertDialog.Builder(this);
            janela.setTitle("ERRO!!!");
            janela.setMessage("Erro valores nulos"+" Sinal: "+sinal+"\n Predict: " + predict);
            janela.setNeutralButton("OK",null);
            janela.show();
        }
    }

    public void onclick(View button){
        predictText.setSinal(button.getTag().toString());
        Intent i = new Intent(SinaisLibras.this, CameraActivity.class);
        startActivityForResult(i, CAMERA_ACTIVITY_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTIVITY_REQUEST_CODE) {
            String prediction = data.getStringExtra("prediction");
            predict= prediction;
            verificar();
        }
    }
}