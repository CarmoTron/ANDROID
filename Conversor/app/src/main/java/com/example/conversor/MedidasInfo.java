package com.example.conversor;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MedidasInfo extends AppCompatActivity {

    Spinner sp;
    private double bytes;
    private EditText by;
    private TextView resultado;

    private String [] medidas = {"Kilobytes","Megabytes","Gigabytes","Terabytes","Petabytes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas_info);


        sp = findViewById(R.id.spiMedidas);
        by = findViewById(R.id.ctxMedidas);
        resultado = findViewById(R.id.ctxresultadoInfo);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,medidas);
        sp.setAdapter(adapter);
        String mostraMedida = sp.getSelectedItem().toString();
        Button btnconverte = findViewById(R.id.btnMedida);
        btnconverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               converterMedida(v);}
        });
    }

    public void converterMedida(View v){
        String valorBytes = by.getText().toString();
        if(!valorBytes.isEmpty()) {
            bytes = Double.parseDouble(valorBytes);
            String itemSelecionado = sp.getSelectedItem().toString();
            double resultadoObtido = contas(bytes, itemSelecionado);
            resultado.setText(String.format("%.2f %s", resultadoObtido, itemSelecionado));
        }else {
            by.setError("Indique o valor");
        }
    }
    public void voltar(View v) {
        Intent it = new Intent(MedidasInfo.this, Menu.class);
        startActivity(it);
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(MedidasInfo.this, Menu.class);
        startActivity(it);
        finish();
    }
    private double contas(double bytes, String medidas){

        switch(medidas) {

            case "Kilobytes":
                return bytes/1024;
            case "Megabytes":
                return bytes/ Math.pow (1024,2);
            case "Gigabytes":
                return bytes / Math.pow (1024,3);
            case "Terabytes":
                return bytes / Math.pow (1024,4);
            case "Petabytes":
                return bytes / Math.pow (1024,5);
            default:
                return 0;
        }
    }
}