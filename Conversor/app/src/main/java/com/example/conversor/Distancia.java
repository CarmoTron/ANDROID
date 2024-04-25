package com.example.conversor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Distancia extends AppCompatActivity {

    Spinner sp;
    private double metros;
    private EditText metro;
    private TextView resultado;
    private String [] distancia = {"KM","Milhas","Jardas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancia);
// criacao de instancias
        sp = findViewById(R.id.spi);
        metro = findViewById(R.id.ctxmetro);
        resultado = findViewById(R.id.resultadoMoedas);
//criar arrays para o spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,distancia);
        sp.setAdapter(adapter);
        String mostraDistancia = sp.getSelectedItem().toString();
//botao converte
        Button btnconverte = findViewById(R.id.btnconverte);
        btnconverte.setOnClickListener(new View.OnClickListener() {
            @Override
            //click converter
            public void onClick(View v) {
                converterDistancia(v);
            };
        });
    }
    //funcao para a distancia ser convertida
    public void converterDistancia(View v){

        String valorMetros = metro.getText().toString();
        if (!valorMetros.isEmpty()){
            metros = Double.parseDouble(valorMetros);
            String distanciaSelecionada = sp.getSelectedItem().toString();
            double resultadoObtido = contas(metros,distanciaSelecionada);
            resultado.setText(String.format("%.2f %s",resultadoObtido,distanciaSelecionada));

        }else {
            metro.setError("Indique o valor");
        }


    }
    //funcao para voltar ao menu
    public void voltar(View v){
        Intent it = new Intent(Distancia.this,Menu.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(Distancia.this, Menu.class);
        startActivity(it);
        finish();
    }
    //funcao para saber qual sera a distancia escolhida
    //e para ser calculada
    private double contas(double metros, String medidas){

        switch(medidas) {

            case "KM":
                return metros/1000;
            case "Milhas":
                return metros / 1609.344;
            case "Jardas":
                return metros * 1.094;
            default:
                return 0;
        }
    }
}