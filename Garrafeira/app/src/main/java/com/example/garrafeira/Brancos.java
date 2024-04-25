package com.example.garrafeira;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Brancos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brancos);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_vinhos,menu);
        menu.removeItem(R.id.brancos);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){

            finish();
        }else if (id==R.id.tintos){
            Intent it = new Intent(Brancos.this,Tintos.class);
            startActivity(it);
            finish();
        }else if (id==R.id.espirituosos){
            Intent it = new Intent(Brancos.this,Espirituosos.class);
            startActivity(it);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}