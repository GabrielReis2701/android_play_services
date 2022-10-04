package org.tensorflow.lite.examples.classification.playservices;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SinaisLibras extends AppCompatActivity {
    private Button bt_s;
    private String sinal;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_libras);

        bt_s = findViewById(R.id.bt_s);
        bt_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinal = "S";
                Intent intent = new Intent(SinaisLibras.this,CameraActivity.class);
                intent.putExtra("desejado",sinal);
                startActivity(intent);
            }
        });
        Intent volto = getIntent();
        if(volto != null){
            String resultado =volto.getStringExtra("predict");
            String desejado = volto.getStringExtra("desejado2");
            if(sinal==resultado){
                AlertDialog.Builder janela = new AlertDialog.Builder(this);
                janela.setTitle("Resultado da Atividade");
                janela.setMessage("Parabens vc Acertou!!!!!\n vc Fez a Letra: " + resultado);
                janela.setNeutralButton("OK",null);
                janela.show();
            }
        }
    }
}