package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//splashscreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this,Menu.class);
                startActivity(it);
                finish();
            }
        },4000);
    }
}