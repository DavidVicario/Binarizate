package com.davidvicario.binarizate_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Arrays para binario
    private static final int [] idArray1 = {R.id.btB0, R.id.btB1, R.id.btB2, R.id.btB3, R.id.btB4,
            R.id.btB5, R.id.btB6, R.id.btB7};
    private int boton [] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    //Calcular binario
    private int dec = 0;
    private int bin = 0;

    //Conteo de puntos
    private int cont = 0;
    private int puntos = 0;

    //Cuenta atras
    TextView crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultar barra de aplicaciones
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        //Cuenta atras al iniciar el programa.
        crono = (TextView) findViewById(R.id.textCrono);
        cuentaAtras();

        //Cajas
        final TextView cajaPuntos = findViewById(R.id.textPuntos);
        final EditText txtDecimal = findViewById(R.id.textDecimal);
        final Button comprobar = findViewById(R.id.btnComprobar);

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec = Integer.parseInt(String.valueOf(txtDecimal.getText()));
                bin = convertir();

                if (dec == bin){
                    puntos ++;
                }
                binIA();
                //cuentaAtras();

                cajaPuntos.setText("Puntos: " + puntos);

                bin = 0;
                dec = 0;
            }
        });
    }

    //Al iniciar coloca un binario random
    @Override
    protected void onResume(){
        super.onResume();
        binIA();
    }

    //Cuenta atras del juego
    private void cuentaAtras() {
        new CountDownTimer(15000,1000){
            @Override
            public void onTick(long l) {
                long segRestante = l/1000;
                crono.setText(segRestante+" s");
            }
            @Override
            public void onFinish() {
                crono.setText("Fin.");
                crono.setTextColor(Color.RED);
            }
        }.start();
    }

    public int convertir(){

        String binario = String.valueOf(boton);

        int[] bits = new int[binario.length()];
        for (int i = 0; i < bits.length; i++){
            bits[i] = Character.getNumericValue(binario.charAt(i));
        }

        int exponente  = 0;
        int valorDecimal = 0;

        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 1){
                valorDecimal += Math.pow(2, exponente);
            }
            exponente++;
        }
        return valorDecimal;
    }

    //Coloca los uno random
    public void binIA(){
        Random ran = new Random();
        int bina = ran.nextInt(boton.length);
        while (boton[bina] != 0){
            bina = ran.nextInt(boton.length);
        }
        Button b = (Button) findViewById(idArray1[bina]);
        b.setText("1");
        boton [bina] = 1;
    }

    //Cambio a segunda actividad
    public void decimal (View view){
        Intent deci = new Intent(this, SecondActivity.class);
        startActivities(new Intent[]{deci});
    }
}