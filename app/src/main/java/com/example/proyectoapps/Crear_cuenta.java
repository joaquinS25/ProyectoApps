package com.example.proyectoapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Crear_cuenta extends AppCompatActivity {
  Button btnRegistrarUsuario;
  EditText  txtNombreUser, txtApellidoUser,txtEdadUser,txtDNIUser,txtCelularUser,txtEmailUser;
  private FirebaseFirestore mfirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        this.setTitle("Registrar Usuario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();


        txtNombreUser = findViewById(R.id.txtNombreUser);
        txtApellidoUser = findViewById(R.id.txtApellidoUser);
        txtEdadUser = findViewById(R.id.txtEdadUser);
        txtDNIUser = findViewById(R.id.txtDNIUser);
        txtCelularUser = findViewById(R.id.txtCelularUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUser = txtNombreUser.getText().toString().trim();
                String apellidoUser =txtApellidoUser.getText().toString().trim();
                int edadUser = Integer.parseInt(txtEdadUser.getText().toString().trim());
                String dniUser = txtDNIUser.getText().toString().trim();
                String celularUser = txtCelularUser.getText().toString().trim();
                String emailUser = txtEmailUser.getText().toString().trim();
                if (nombreUser.isEmpty() && apellidoUser.isEmpty() && dniUser.isEmpty() && celularUser.isEmpty() && emailUser.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingresar datos", Toast.LENGTH_SHORT).show();
                }else {
                    PostUser(nombreUser,apellidoUser,edadUser,dniUser,celularUser,emailUser);
                }
            }
        });
    }

    private void PostUser(String nombreUser, String apellidoUser, int edadUser, String dniUser, String celularUser, String emailUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("txtNombreUser",txtNombreUser);
        map.put("txtApellidoUser",txtNombreUser);
        map.put("txtEdadUser",txtNombreUser);
        map.put("txtDNIeUser",txtNombreUser);
        map.put("txtCelularUser",txtNombreUser);
        map.put("txtEmailUser",txtNombreUser);

        mfirestore.collection("user").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"Creado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*@Override
    public boolean onSuppotABooleanNavigateUp(){
        onBackPressed();
        return false;
    }*/

}