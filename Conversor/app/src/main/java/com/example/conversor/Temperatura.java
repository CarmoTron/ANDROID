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

public class Temperatura extends AppCompatActivity {

    Spinner spOrigem, spDestino;
    private double temperatura;
    private EditText t;
    private TextView resultado;
    private String[] tempDivers = {"Celsius", "Kelvin", "Fahrenheit"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        spOrigem = findViewById(R.id.SpTOrigem);
        spDestino = findViewById(R.id.SpTDestino);
        t = findViewById(R.id.ctxTemp);
        resultado = findViewById(R.id.ctxResTemp);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tempDivers);
        spOrigem.setAdapter(adapter);
        spDestino.setAdapter(adapter);

        Button btnconverte = findViewById(R.id.btnTempRes);

        btnconverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converterTemperatura(v);
            }
        });
    }

    public void converterTemperatura(View v) {
        String valorTemperatura = t.getText().toString();
        if (!valorTemperatura.isEmpty()) {
            temperatura = Double.parseDouble(valorTemperatura);
            String temperaturaOrigem = spOrigem.getSelectedItem().toString();
            String temperaturaDestino = spDestino.getSelectedItem().toString();
            double resultadoObtido = contas(temperatura, temperaturaOrigem, temperaturaDestino);
            resultado.setText(String.format("%.2f %s", resultadoObtido, temperaturaDestino));

        } else {
            t.setError("Indique o valor");
        }
    }

    public void voltar(View v) {
        Intent it = new Intent(Temperatura.this, Menu.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(Temperatura.this, Menu.class);
        startActivity(it);
        finish();
    }
    private double contas(double temperatura, String medidasOrigem, String medidasDestino) {

        switch(medidasOrigem){
            case "Celsius":
                switch (medidasDestino){
                    case "Celsius":
                        return temperatura;
                    case "Kelvin":
                        return temperatura + 273.15;
                    case "Fahrenheit":
                        return (temperatura * 9/5) +32;
                }
            case "Kelvin":
                switch (medidasDestino){
                    case "Kelvin":
                        if (temperatura < 0){
                            t.setError("Não existe temperatura negativa em Kelvin");
                        }else {
                            return temperatura;
                        }

                    case "Celsius":
                        return temperatura - 273.15;
                    case "Fahrenheit":
                        return 1.8*(temperatura - 273.15) +32;
                }
            case "Fahrenheit":
                switch (medidasDestino){
                    case "Fahrenheit":
                        return temperatura;
                    case "Celsius":
                        return (temperatura - 32)/1.8;
                    case "Kelvin":
                        return (temperatura + 459.67) * 5/9;
                }
        }

        return 0;
    }
}

