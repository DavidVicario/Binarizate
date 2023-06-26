package com.davidvicario.binarizate_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private static final int [] idArray2 = {R.id.btP0, R.id.btP1, R.id.btP2, R.id.btP3, R.id.btP4,
            R.id.btP5, R.id.btP6, R.id.btP7};

    private int boton2 [] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Ocultar barra de aplicaciones
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        final TextView decimalRandom = findViewById(R.id.txtDecimal);
        final TextView marcador = findViewById(R.id.txtMarcador);
        final Button aceptar = findViewById(R.id.btnAceptar);

        final int random = new Random().nextInt(255);

        //decimalRandom.setText(random);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void ponerUno(View v){
        int nBoton = Arrays.asList(idArray2).indexOf(v.getId());
        if (boton2[nBoton] == 0){
            boton2 [nBoton] = 1;
        }
    }

    public void decIA(){
        Random ran = new Random();
        int deci = ran.nextInt(254);

    }

    public void binario (View view){
        Intent bina = new Intent(this, MainActivity.class);
        startActivities(new Intent[]{bina});
    }
}