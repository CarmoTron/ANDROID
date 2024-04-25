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

public class Moedas extends AppCompatActivity {

    Spinner sp;
    private double euros;

    private EditText dinheiro;
    private TextView resultado;

    private String[] money = {"Dolar", "Real", "Libras", "Quanzas", "Xelim"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moedas);

        sp = findViewById(R.id.spiMoedas);
        dinheiro = findViewById(R.id.ctxvalor);
        resultado = findViewById(R.id.resultadoMoedas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, money);
        sp.setAdapter(adapter);
        String mostraDinheiro = sp.getSelectedItem().toString();
        Button btnconverte = findViewById(R.id.converteMoedas);
        btnconverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converterMedida(v);
            }
        });
    }

    public void converterMedida(View v) {
        String valorEuros = dinheiro.getText().toString();
        if(!valorEuros.isEmpty()) {
            euros = Double.parseDouble(valorEuros);
            String itemSelecionado = sp.getSelectedItem().toString();
            double resultadoObtido = contas(euros, itemSelecionado);
            resultado.setText(String.format("%.2f %s", resultadoObtido, itemSelecionado));
        }else {
            dinheiro.setError("Indique o valor");
        }
    }
    public void voltar(View v) {
        Intent it = new Intent(Moedas.this, Menu.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(Moedas.this, Menu.class);
        startActivity(it);
        finish();
    }
    private double contas(double euro, String medidas) {

        switch (medidas) {

            case "Dolar":
                return euros * 1.07;
            case "Real":
                return euros * 5.26;
            case "Libras":
                return euros * 1.15;
            case "Quanzas":
                return euros * 888.27;
            case "Xelim":
                return euros * 161.95;
            default:
                return 0;
        }
    }
}