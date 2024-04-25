package com.example.tube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Animais extends AppCompatActivity {

    private MediaPlayer mp;

    Spinner sp;
    ImageView imgv;
    private TextView txt;
    private String traducao = "";
    private String []nomeAnimais = {"Pássaro","Gato","Cão","Tartaruga"};
    private int [] imgAnimais = {R.drawable.bird,R.drawable.cat,R.drawable.dog,R.drawable.turtle};

    private String [] soundAnimais = new String[] {"oiseau","chat","chien","tortoise"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);


        imgv = findViewById(R.id.animaisId);
        sp = findViewById(R.id.spinnerAni);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,nomeAnimais);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mp != null) {
                    mp.release();
                }
                //atualiza a imagem
                imgv.setImageResource(imgAnimais[position]);
                //obtem o nome da fruta
                String nome = nomeAnimais[position];
                //obtem o som
                String pkg = getPackageName();
                int soundId = getResources().getIdentifier(soundAnimais[position],"raw",pkg);
                //obtem o som correspondente
                mp = MediaPlayer.create(Animais.this,soundId);
                if (nome.equals("Pássaro")){
                    traducao = "Oiseau";
                }else if(nome.equals("Gato")){
                    traducao = "Chat";
                }else if(nome.equals("Cão")){
                    traducao = "Chien";
                }else if(nome.equals("Tartaruga")) {
                    traducao = "Tortoise";
                }

                if (!traducao.equals("")) {
                    Toast.makeText(Animais.this, "Tradução: " + traducao, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void reproduzir(View v){
            mp.start();

    }
// cria o menu de topo
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.removeItem(R.id.animais);
        return super.onCreateOptionsMenu(menu);
    }
// escolhe os item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){

            finish();
        } else if (id==R.id.fruta){
            Intent it = new Intent(Animais.this,Fruta.class);
            startActivity(it);
            finish();
        }else if (id==R.id.uten){
            Intent it = new Intent(Animais.this,Utensi.class);
            startActivity(it);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    //
    public void onBackPressed() {
        Intent it = new Intent(Animais.this,Menu.class);
        startActivity(it);
        finish();
        super.onBackPressed();
    }
}