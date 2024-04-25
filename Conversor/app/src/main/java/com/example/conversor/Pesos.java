package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Pesos extends AppCompatActivity {

    Spinner sp;

    private double peso;
    private EditText opeso;
    private TextView resultado;
    private String[] medidas = {"Kg", "Toneladas", "Lb", "Onças", "Miligramas", "Microgramas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesos);

        sp = findViewById(R.id.spiPesos);
        opeso = findViewById(R.id.ctxPesos);
        resultado = findViewById(R.id.resultadoPeso);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, medidas);
        sp.setAdapter(adapter);
        String mostraPeso = sp.getSelectedItem().toString();
        Button btnconverte = findViewById(R.id.btnPesos);
        btnconverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converterPeso(v);
            }
        });
    }

    public void converterPeso(View v) {
        String valorPeso = opeso.getText().toString();
        if (!valorPeso.isEmpty()) {
            peso = Double.parseDouble(valorPeso);
            String itemSelecionado = sp.getSelectedItem().toString();
            double resultadoObtido = contas(peso, itemSelecionado);
            resultado.setText(String.format("%.2f %s",resultadoObtido, itemSelecionado));
        }else {
            opeso.setError("Indique o valor");
        }
    }

    //funcao para voltar ao menu
    public void voltar(View v) {
        Intent it = new Intent(Pesos.this, Menu.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(Pesos.this, Menu.class);
        startActivity(it);
        finish();
    }

    //funcao para saber qual sera a distancia escolhida
    //e para ser calculada
    private double contas(double peso, String medidas) {

        switch (medidas) {

            case "Kg":
                return peso / 1000;
            case "Toneladas":
                return peso / 1000 * 1000;
            case "Lb":
                return peso * 0.00220462;
            case "Onças":
                return peso / 28.34952;
            case "Miligramas":
                return peso * 1000;
            case "Microgramas":
                return peso * Math.pow(1000,2);
            default:
                return 0;
        }
    }
}