package com.example.proyectoapps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapps.adapter.UserAdapter;
import com.example.proyectoapps.model.User;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListarUsuarios extends AppCompatActivity {

   RecyclerView mRecycler;
    UserAdapter mAdater;
    FirebaseFirestore mFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);
        mFirestore= FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recyclerViewSingle);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("user");

        FirestoreRecyclerOptions<User> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<User>().setQuery(query, User.class).build();
        mAdater = new UserAdapter(firestoreRecyclerOptions, this);
        mAdater.notifyDataSetChanged();
        mRecycler.setAdapter(mAdater);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdater.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdater.stopListening();
    }
}




