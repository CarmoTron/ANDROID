package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IMC extends AppCompatActivity {

    private EditText peso, altura;
    private TextView smsimc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        peso=findViewById(R.id.ctxpeso);
        altura=findViewById(R.id.ctxaltura);
        smsimc=findViewById(R.id.ctximc);
    }

    public void calcula(View v){
        float imc;
        imc = Float.parseFloat(peso.getText().toString())/
                (Float.parseFloat(altura.getText().toString())*
                        Float.parseFloat(altura.getText().toString()));

        smsimc.setText("IMC: "+imc+"\n");
        String s = "";
        if (imc<18.5) s=getString(R.string.imc1);
        else if(imc<25) s=getString(R.string.imc2);
        else if(imc<30) s=getString(R.string.imc3);
        else if(imc<35) s=getString(R.string.imc4);
        else if(imc<40) s=getString(R.string.imc5);
        else s ="Obesidade Grau III ou Mórbida";

        smsimc.append(s);

    }
    public void sair(View v){
        finish();
    }
}