package com.example.tube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showMessage();
            }
        },2000);

    }
    private void showMessage() {
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Termos e Condições:");
        msgbox.setIcon(android.R.drawable.ic_menu_info_details);
        msgbox.setMessage("Esta app é para fins educativos, esta mensagem é uma amostra de como funciona uma msgbox, deseja continuar?");
        msgbox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent it = new Intent(MainActivity.this,Menu.class);
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
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.removeItem(R.id.fruta);
        menu.removeItem(R.id.uten);
        menu.removeItem(R.id.animais);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){

            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}