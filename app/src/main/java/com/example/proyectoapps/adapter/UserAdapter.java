package com.example.proyectoapps.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapps.Crear_cuenta;
import com.example.proyectoapps.R;
import com.example.proyectoapps.model.User;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserAdapter  extends FirestoreRecyclerAdapter<User, UserAdapter.ViewHolder>{
        private FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
        Activity activity;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirestoreRecyclerOptions<User> options, Activity activity) {
        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull User model) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());
        final String id = documentSnapshot.getId();

        viewHolder.nombreUser.setText(model.getNombreUser());
        viewHolder.apellidoUser.setText(model.getApellidoUser());
        viewHolder.DNIUser.setText(model.getDniUser());
        viewHolder.edadUser.setText(String.valueOf(model.getEdadUser())); // Convertir Long a String
        viewHolder.celularUser.setText(model.getCelularUser());
        viewHolder.emailUser.setText(model.getEmailUser());
        viewHolder.btn_eliminar.setOnClickListener(v -> deleteUser(id));
        viewHolder.btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, Crear_cuenta.class);
                i.putExtra("id_user", id);
                activity.startActivity(i);
            }
        });
    }

    private void deleteUser(String id) {
        mFirestore.collection("user").document(id).delete().addOnSuccessListener(unused -> Toast.makeText(activity,"Eliminado exitosamente", Toast.LENGTH_SHORT).show()).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity,"Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreUser, apellidoUser, DNIUser, celularUser, edadUser,emailUser;
        ImageButton btn_eliminar, btn_editar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreUser = itemView.findViewById(R.id.nombre);
            apellidoUser = itemView.findViewById(R.id.apellido);
            DNIUser = itemView.findViewById(R.id.dni);
            celularUser = itemView.findViewById(R.id.celular);
            edadUser = itemView.findViewById(R.id.edad);
            emailUser = itemView.findViewById(R.id.email);
            btn_eliminar = itemView.findViewById(R.id.btn_eliminar);
            btn_editar = itemView.findViewById(R.id.btnEditar);
        }
    }
}
