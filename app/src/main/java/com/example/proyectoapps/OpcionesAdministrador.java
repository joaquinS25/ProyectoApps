package com.example.proyectoapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OpcionesAdministrador extends AppCompatActivity {
    Button btnUsers,btnPeliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_administrador);
        asignarReferencias();
        asignarReferencias1();
    }
    private void asignarReferencias(){
        btnUsers=findViewById(R.id.btnUsers);
        btnUsers.setOnClickListener(v -> {
            Intent intent =new Intent(this, ListarUsuarios.class);
            startActivity(intent);
        });
    }
    private void asignarReferencias1(){
        btnPeliculas=findViewById(R.id.btnPeliculas);
        btnPeliculas.setOnClickListener(v -> {
            Intent intent =new Intent(this, ListarPeliculas.class);
            startActivity(intent);
        });
    }
}