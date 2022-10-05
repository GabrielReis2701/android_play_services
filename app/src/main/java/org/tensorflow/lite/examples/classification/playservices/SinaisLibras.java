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
    //private ImageButton bt_s,bt_a;
    private String sinal="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_libras);

        /*bt_a = findViewById(R.id.bt_a);
        bt_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinal = "A";
                Intent i = new Intent(SinaisLibras.this,CameraActivity.class);
                i.putExtra("desejado",sinal);
                startActivity(i);
            }
        });
        bt_s = findViewById(R.id.bt_s);
        bt_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinal = "S";
                Intent i = new Intent(SinaisLibras.this,CameraActivity.class);
                i.putExtra("desejado",sinal);
                startActivity(i);
            }
        });*/
        Intent volto = getIntent();
        if(volto.getStringExtra("predict") != null){
            String resultado =volto.getStringExtra("predict");
            String desejado = volto.getStringExtra("desejado2");
            if(desejado.toUpperCase().equals(resultado.toUpperCase())){
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Parabens vc Acertou!!!!!\n vc Fez a Letra: " + resultado);
                janela.setNeutralButton("OK",null);
                janela.show();
                sinal="";
            }else{
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Vc deveria fazer a letra: "+desejado+" vc Fez a Letra: " + resultado +" Letra Incorreta Por Favor Refaça");
                janela.setNeutralButton("OK",null);
                janela.show();
                sinal="";
            }
        }
    }
    public void onclick(View button){
        int tag =-1;
        tag = (int) Integer.parseInt(button.getTag().toString());
        sinal="";
        if (tag==0){
            sinal = "A";
        }else if (tag==1){
            sinal = "B";
        }else if (tag==2){
            sinal = "C";
        } else if (tag==3){
            sinal = "D";
        } else if (tag==4){
            sinal = "E";
        } else if (tag==5){
            sinal = "F";
        }
        else if (tag==6){
            sinal = "G";
        }
        else if (tag==7){
            sinal = "H";
        }
        else if (tag==8){
            sinal = "I";
        }
        else if (tag==9){
            sinal = "J";
        }
        else if (tag==10){
            sinal = "K";
        }
        else if (tag==11){
            sinal = "L";
        }
        else if (tag==12){
            sinal = "M";
        }
        else if (tag==13){
            sinal = "N";
        }
        else if (tag==14){
            sinal = "O";
        }
        else if (tag==15){
            sinal = "P";
        }
        else if (tag==16){
            sinal = "Q";
        }
        else if (tag==17){
            sinal = "R";
        }
        else if (tag==18){
            sinal = "S";
        }
        else if (tag==19){
            sinal = "T";
        }
        else if (tag==20){
            sinal = "U";
        }
        else if (tag==21){
            sinal = "V";
        }
        else if (tag==22){
            sinal = "W";
        }
        else if (tag==23){
            sinal = "X";
        }
        else if (tag==24){
            sinal = "Y";
        }
        else {
            sinal = "Z";
        }
        if(tag!=-1){
            Intent i = new Intent(SinaisLibras.this,CameraActivity.class);
            i.putExtra("desejado",sinal);
            startActivity(i);
        }else{
            System.out.println("ERRO");
        }

    }
}