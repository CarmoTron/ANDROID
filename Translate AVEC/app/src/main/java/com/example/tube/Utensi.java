package com.example.tube;

import static android.app.ProgressDialog.show;

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

public class Utensi extends AppCompatActivity {

    private MediaPlayer mp;

    Spinner sp;
    ImageView imgv;
    private TextView txt;
    //array
    private String []nomeUtensilios =  {"Colher","Garfo","Faca","Espatula"};
    private int [] imgUtensilios = {R.drawable.spoon,R.drawable.fork,R.drawable.knife,R.drawable.spatula};

    private String [] soundUtensilios = new String[]{"cuillere","fourchette","couteau","spatule"};
    private String traducao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utensi);


        imgv = findViewById(R.id.utensiId);
        sp = findViewById(R.id.spinnerUtensi);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,nomeUtensilios);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mp != null) {
                    mp.release();
                }
                //atualiza a imagem
                imgv.setImageResource(imgUtensilios[position]);
                //obtem o nome da fruta
                String nome = nomeUtensilios[position];
                //obtem o som
                String pkg = getPackageName();
                int soundId = getResources().getIdentifier(soundUtensilios[position],"raw",pkg);
                //obtem o som correspondente
                mp = MediaPlayer.create(Utensi.this,soundId);


                if (nome.equals("Colher")){
                    traducao = "Cuillere";
                }else if(nome.equals("Garfo")){
                    traducao = "Fourchette";
                }else if(nome.equals("Faca")){
                    traducao = "Couteau";
                }else if(nome.equals("Espatula")) {
                    traducao = "Spatula";
                }
                if (!traducao.equals("")) {
                    Toast.makeText(Utensi.this, "Tradução: " + traducao, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //reproduz
    public void reproduzir(View v){
        //     if (mp != null) {
        mp.start();
        //   }
    }

    // aparece opcao itens no menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.removeItem(R.id.uten);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.sair){
            finish();

        } else if (id==R.id.fruta){
            Intent it = new Intent(Utensi.this,Fruta.class);
            startActivity(it);
            finish();
        }else if (id==R.id.animais){
            Intent it = new Intent(Utensi.this,Animais.class);
            startActivity(it);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        Intent it = new Intent(Utensi.this,Menu.class);
        startActivity(it);
        finish();
        super.onBackPressed();
    }
}