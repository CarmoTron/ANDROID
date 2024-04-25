package com.example.garrafeira;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showMessage();
            }
        },3500);
    }

    private void showMessage() {
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Verificação de idade");
        msgbox.setIcon(android.R.drawable.ic_menu_info_details);
        msgbox.setMessage("Tem idade legal para consumir bebidas alcoólicas?");
        msgbox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent it = new Intent(MainActivity.this,Tintos.class);
                startActivity(it);
                finish();
            }
        });
        msgbox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        msgbox.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_vinhos,menu);
        menu.removeItem(R.id.tintos);
        menu.removeItem(R.id.brancos);
        menu.removeItem(R.id.espirituosos);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){

            finish();
        } else if (id==R.id.tintos){
            Intent it = new Intent(MainActivity.this,Tintos.class);
            startActivity(it);
            finish();
        }else if (id==R.id.brancos){
            Intent it = new Intent(MainActivity.this,Brancos.class);
            startActivity(it);
            finish();
        }else if (id==R.id.espirituosos){
            Intent it = new Intent(MainActivity.this,Espirituosos.class);
            startActivity(it);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}