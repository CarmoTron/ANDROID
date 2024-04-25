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

public class Fruta extends AppCompatActivity {

    private MediaPlayer mp;

    Spinner sp;
    ImageView imgv;
    private TextView txt;

    private String []nomeFrutas = {"Morango","Melancia","Pêssego","Pêra","Ananás"};
    private int [] imgFrutas = {R.drawable.strawberry,R.drawable.watermelon,R.drawable.peach,R.drawable.pear,R.drawable.pineapple};

    private String [] soundFrutas = new String[]{"fraise","pasteque","peche","poire","ananas"};

    private String traducao = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruta);


        imgv = findViewById(R.id.frutaId);
        sp = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,nomeFrutas);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mp != null) {
                    mp.release();
                }
                //atualiza a imagem
                imgv.setImageResource(imgFrutas[position]);
                //obtem o nome da fruta
                String nome = nomeFrutas[position];
                //obtem o som
                String pkg = getPackageName();
                int soundId = getResources().getIdentifier( soundFrutas[position],"raw",pkg);
                //obtem o som correspondente
                mp = MediaPlayer.create(Fruta.this,soundId);
                if (nome.equals("Morango")){
                    traducao = "Fraise";
                }else if(nome.equals("Melancia")){
                    traducao = "Pásteque";
                }else if(nome.equals("Pêssego")){
                    traducao = "Pêche";
                }else if(nome.equals("Pêra")) {
                    traducao = "Poire";
                }
                else if(nome.equals("Ananás")) {
                    traducao = "Ananas";
                }
                if (!traducao.equals("")) {
                    Toast.makeText(Fruta.this, "Tradução: " + traducao, Toast.LENGTH_LONG).show();
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
    // aparece opcao itens no menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.removeItem(R.id.fruta);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){
            finish();

        } else if (id==R.id.uten){
            Intent it = new Intent(Fruta.this,Utensi.class);
            startActivity(it);
            finish();
        }else if (id==R.id.animais){
            Intent it = new Intent(Fruta.this,Animais.class);
            startActivity(it);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        Intent it = new Intent(Fruta.this,Menu.class);
        startActivity(it);
        finish();
        super.onBackPressed();
    }
}