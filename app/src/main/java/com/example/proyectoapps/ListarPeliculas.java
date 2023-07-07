package com.example.proyectoapps;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ListarPeliculas extends AppCompatActivity {
    ImageButton btnAgregarPelicula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_peliculas);
        btnAgregarPelicula  = findViewById(R.id.btnAgregarPelicula);
        btnAgregarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearPeliculasFragment fm = new CrearPeliculasFragment();
                fm.show(getSupportFragmentManager(), "Navegar a fragment");
            }
        });
    }
}