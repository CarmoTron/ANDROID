package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void entrarDistancia(View v){
        Intent it = new Intent(Menu.this,Distancia.class);
        startActivity(it);
        finish();

    }
    public void entrarInformatica(View v){
        Intent it = new Intent(Menu.this,MedidasInfo.class);
        startActivity(it);
        finish();
    }
    public void entrarMoedas(View v){
        Intent it = new Intent(Menu.this,Moedas.class);
        startActivity(it);
        finish();

    }
    public void entrarPesos(View v){
        Intent it = new Intent(Menu.this,Pesos.class);
        startActivity(it);
        finish();

    }
    public void entrarTemperatura(View v){
        Intent it = new Intent(Menu.this,Temperatura.class);
        startActivity(it);
        finish();

    }
    public void sair (View v){
        finish();
    }
}