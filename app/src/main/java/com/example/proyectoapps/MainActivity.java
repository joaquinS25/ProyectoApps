package com.example.proyectoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnIniciarSesion, btnCrearCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarReferencias();
        asignarReferencias1();
    }
    private void asignarReferencias(){
        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(this, PrimeraPelicula.class);
            startActivity(intent);
        });

    }
    private void asignarReferencias1(){
        btnCrearCuenta=findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(v -> {
            Intent intent = new Intent(this, Crear_cuenta.class);
            startActivity(intent);
        });

    }
}