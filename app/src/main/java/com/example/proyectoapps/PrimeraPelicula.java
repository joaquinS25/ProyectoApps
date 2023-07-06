package com.example.proyectoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PrimeraPelicula extends AppCompatActivity {
    Button btnAtras, btnSig, btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pelicula);
        asignarReferencias();
        asignarReferencias1();
        asignarReferencias2();

    }
    private void asignarReferencias(){
        btnSig=findViewById(R.id.btn_sig);
        btnSig.setOnClickListener(v -> {
            Intent intent = new Intent(this, SegundaPelicula.class);
            startActivity(intent);
        });

    }
    private void asignarReferencias1(){
        btnAtras=findViewById(R.id.btn_atras);
        btnAtras.setOnClickListener(v -> {
            Intent intent =new Intent(this, CuartaPelicula.class);
            startActivity(intent);
        });
    }
    private void asignarReferencias2(){
        btnContinue=findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(v -> {
            Intent intent =new Intent(this, SeleccionarAsientos.class);
            startActivity(intent);
        });
    }
}