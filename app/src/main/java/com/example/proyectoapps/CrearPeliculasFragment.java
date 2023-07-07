package com.example.proyectoapps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class CrearPeliculasFragment extends DialogFragment {
    Button btnRegistrarPelicula;
    EditText txtTitulo, txtAutor, txtDuracion, txtGenero;
    CheckBox ch12pm, ch2pm, ch4pm, ch6pm, ch2D, ch3D;
    private FirebaseFirestore mfirestore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crear_peliculas, container, false);
        mfirestore = FirebaseFirestore.getInstance();
        txtTitulo = v.findViewById(R.id.txtTittulo);
        txtAutor = v.findViewById(R.id.txtAutor);
        txtDuracion = v.findViewById(R.id.txtDuracion);
        txtGenero = v.findViewById(R.id.txtGenero);
        ch12pm = v.findViewById(R.id.ch12pm);
        ch2pm = v.findViewById(R.id.ch2pm);
        ch4pm = v.findViewById(R.id.ch4pm);
        ch6pm = v.findViewById(R.id.ch6pm);
        ch2D = v.findViewById(R.id.ch2D);
        ch3D = v.findViewById(R.id.ch3D);
        btnRegistrarPelicula = v.findViewById(R.id.btnRegistrarPelicula);

        btnRegistrarPelicula.setOnClickListener(v1 -> {
            String titulo = txtTitulo.getText().toString().trim();
            String autor = txtAutor.getText().toString().trim();
            String duracion = txtDuracion.getText().toString().trim();
            String genero = txtGenero.getText().toString().trim();
            boolean is12pm = ch12pm.isChecked();
            boolean is2pm = ch2pm.isChecked();
            boolean is4pm = ch4pm.isChecked();
            boolean is6pm = ch6pm.isChecked();
            boolean is2D = ch2D.isChecked();
            boolean is3D = ch3D.isChecked();

            if (titulo.isEmpty() || autor.isEmpty() || duracion.isEmpty() || genero.isEmpty()) {
                Toast.makeText(getContext(), "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
            } else {
                postPelicula(titulo, autor, duracion, genero, is12pm, is2pm, is4pm, is6pm, is2D, is3D);
            }
        });

        return v;
    }

    private void postPelicula(String titulo, String autor, String duracion, String genero,
                              boolean is12pm, boolean is2pm, boolean is4pm, boolean is6pm,
                              boolean is2D, boolean is3D) {
        Map<String, Object> map = new HashMap<>();
        map.put("titulo", titulo);
        map.put("autor", autor);
        map.put("duracion", duracion);
        map.put("genero", genero);
        map.put("is12pm", is12pm);
        map.put("is2pm", is2pm);
        map.put("is4pm", is4pm);
        map.put("is6pm", is6pm);
        map.put("is2D", is2D);
        map.put("is3D", is3D);

        mfirestore.collection("peliculas").add(map)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(getContext(), "Película registrada exitosamente", Toast.LENGTH_SHORT).show();
                    dismiss(); // Cerrar el fragmento después de registrar la película
                })
                .addOnFailureListener(e -> Toast.makeText(getContext(), "Error al registrar la película", Toast.LENGTH_SHORT).show());
    }
}
