package com.example.proyectoapps;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapps.adapter.PeliculaAdapter;
import com.example.proyectoapps.model.Pelicula;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListarPeliculas extends AppCompatActivity {
    ImageButton btnAgregarPelicula;
    RecyclerView mRecycler;
    PeliculaAdapter mAdapter;
    FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_peliculas);

        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recyclerViewPeliculas);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("peliculas");

        FirestoreRecyclerOptions<Pelicula> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Pelicula>().setQuery(query, Pelicula.class).build();
        mAdapter = new PeliculaAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        btnAgregarPelicula  = findViewById(R.id.btnAgregarPelicula);
        btnAgregarPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearPeliculasFragment fm = new CrearPeliculasFragment();
                fm.show(getSupportFragmentManager(), "Navegar a fragment");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}