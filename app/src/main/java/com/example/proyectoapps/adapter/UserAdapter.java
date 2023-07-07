package com.example.proyectoapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapps.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.example.proyectoapps.model.User;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class UserAdapter  extends FirestoreRecyclerAdapter<User, UserAdapter.ViewHolder>{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirestoreRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int position, @NonNull User model) {
        viewHolder.nombreUser.setText(model.getNombreUser());
        viewHolder.apellidoUser.setText(model.getApellidoUser());
        viewHolder.DNIUser.setText(model.getDniUser());
        viewHolder.edadUser.setText(String.valueOf(model.getEdadUser())); // Convertir Long a String
        //viewHolder.edadUser.setText(model.getEdadUser());
        viewHolder.celularUser.setText(model.getCelularUser());
        viewHolder.emailUser.setText(model.getEmailUser());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_single,parent,false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreUser, apellidoUser, DNIUser, celularUser, edadUser,emailUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreUser = itemView.findViewById(R.id.nombre);
            apellidoUser = itemView.findViewById(R.id.apellido);
            DNIUser = itemView.findViewById(R.id.dni);
            celularUser = itemView.findViewById(R.id.celular);
            edadUser = itemView.findViewById(R.id.edad);
            emailUser = itemView.findViewById(R.id.email);

        }
    }
}
