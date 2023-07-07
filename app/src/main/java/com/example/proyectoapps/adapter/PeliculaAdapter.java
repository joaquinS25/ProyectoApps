package com.example.proyectoapps.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapps.CrearPeliculasFragment;
import com.example.proyectoapps.R;
import com.example.proyectoapps.model.Pelicula;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PeliculaAdapter extends FirestoreRecyclerAdapter<Pelicula, PeliculaAdapter.ViewHolder> {
    private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
    FragmentManager fm;
    Activity activity;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PeliculaAdapter(@NonNull FirestoreRecyclerOptions<Pelicula> options, Activity activity, FragmentManager fm) {
        super(options);
        this.activity = activity;
        this.fm = fm;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull Pelicula model) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        viewHolder.txtTitulo.setText(model.getTitulo());
        viewHolder.txtAutor.setText(model.getAutor());
        viewHolder.txtDuracion.setText(model.getDuracion());
        viewHolder.txtGenero.setText(model.getGenero());
        viewHolder.ch12pm.setChecked(model.isIs12pm());
        viewHolder.ch2pm.setChecked(model.isIs2pm());
        viewHolder.ch4pm.setChecked(model.isIs4pm());
        viewHolder.ch6pm.setChecked(model.isIs6pm());
        viewHolder.ch2D.setChecked(model.isIs2D());
        viewHolder.ch3D.setChecked(model.isIs3D());

        viewHolder.btn_eliminar.setOnClickListener(v -> deletePelicula(id));
        viewHolder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, CrearPeliculasFragment.class);
                i.putExtra("id_pelicula", id);
                //activity.startActivity(i);

                CrearPeliculasFragment crearPeliculasFragment = new CrearPeliculasFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id_pelicula",id);
                crearPeliculasFragment.setArguments(bundle);
                crearPeliculasFragment.show(fm, "open fragment");
            }
        });
    }

    private void deletePelicula(String id) {
        mFirestore.collection("peliculas").document(id).delete().addOnSuccessListener(unused -> Toast.makeText(activity,"Eliminado exitosamente", Toast.LENGTH_SHORT).show()).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity,"Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pelicula_single ,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtAutor, txtDuracion, txtGenero;
        CheckBox ch12pm, ch2pm, ch4pm, ch6pm, ch2D, ch3D;
        ImageButton btn_eliminar, btn_editar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.titulo);
            txtAutor = itemView.findViewById(R.id.autor);
            txtDuracion = itemView.findViewById(R.id.duracion);
            txtGenero = itemView.findViewById(R.id.genero);
            ch12pm = itemView.findViewById(R.id.ch12pm);
            ch2pm = itemView.findViewById(R.id.ch2pm);
            ch4pm = itemView.findViewById(R.id.ch4pm);
            ch6pm = itemView.findViewById(R.id.ch6pm);
            ch2D = itemView.findViewById(R.id.ch2D);
            ch3D = itemView.findViewById(R.id.ch3D);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
            btn_editar = itemView.findViewById(R.id.btnEditar);
        }
    }
}
