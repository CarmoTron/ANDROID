package com.example.tube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void entraFrutas(View v){
        Intent it = new Intent(Menu.this,Fruta.class);
        startActivity(it);
        finish();
    }
    public void entraUten(View v){
        Intent it = new Intent(Menu.this,Utensi.class);
        startActivity(it);
        finish();
    }
    public void entraAnimais(View v){
        Intent it = new Intent(Menu.this,Animais.class);
        startActivity(it);
        finish();
    }
    public void sair(View v){

        finish();
    }
}