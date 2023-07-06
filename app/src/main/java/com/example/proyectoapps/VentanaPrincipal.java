package com.example.proyectoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class VentanaPrincipal extends AppCompatActivity {
    Button btnAdmin, btnUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);
        asignarReferencias();
        asignarReferencias1();
    }
    private void asignarReferencias(){
        btnAdmin=findViewById(R.id.btnAdmin);
        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginAdministrador.class);
            startActivity(intent);
        });

    }
    private void asignarReferencias1(){
        btnUser=findViewById(R.id.btnUser);
        btnUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}