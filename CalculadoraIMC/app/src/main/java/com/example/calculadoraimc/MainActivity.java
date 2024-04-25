package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private int TEMPO = 4800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // implementar o splash screen
        //apos um delay passa para outra class
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // chamar activity IMC
                Intent it = new Intent(MainActivity.this,IMC.class);
                startActivity(it);
                finish();
            }
        },TEMPO);

    }
}