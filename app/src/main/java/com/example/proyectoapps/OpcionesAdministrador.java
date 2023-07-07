package com.example.proyectoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class OpcionesAdministrador extends AppCompatActivity {
    Button btnUsers,btnPeliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_administrador);
        asignarReferencias();
    }
    private void asignarReferencias(){
        btnUsers=findViewById(R.id.btnUsers);
        btnUsers.setOnClickListener(v -> {
            Intent intent =new Intent(this, ListarUsuarios.class);
            startActivity(intent);
        });
    }
}