package com.example.proyectoapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Crear_cuenta extends AppCompatActivity {
    Button btnRegistrarUsuario;
    EditText txtNombreUser, txtApellidoUser, txtEdadUser, txtDNIUser, txtCelularUser, txtEmailUser;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        //this.setTitle("Registrar Usuario");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra("id_user");
        mfirestore = FirebaseFirestore.getInstance();

        txtNombreUser = findViewById(R.id.txtNombreUser);
        txtApellidoUser = findViewById(R.id.txtApellidoUser);
        txtEdadUser = findViewById(R.id.txtEdadUser);
        txtDNIUser = findViewById(R.id.txtDNIUser);
        txtCelularUser = findViewById(R.id.txtCelularUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        if (id == null || id.isEmpty()) {
            btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombreUser = txtNombreUser.getText().toString().trim();
                    String apellidoUser = txtApellidoUser.getText().toString().trim();
                    int edadUser = Integer.parseInt(txtEdadUser.getText().toString().trim());
                    String dniUser = txtDNIUser.getText().toString().trim();
                    String celularUser = txtCelularUser.getText().toString().trim();
                    String emailUser = txtEmailUser.getText().toString().trim();

                    if (nombreUser.isEmpty() || apellidoUser.isEmpty() || dniUser.isEmpty() || celularUser.isEmpty() || emailUser.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
                    } else {
                        PostUser(nombreUser, apellidoUser, edadUser, dniUser, celularUser, emailUser);
                    }
                }
            });
        } else {
            btnRegistrarUsuario.setText("Actualizar");
            getUser(id);
            btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombreUser = txtNombreUser.getText().toString().trim();
                    String apellidoUser = txtApellidoUser.getText().toString().trim();
                    int edadUser = Integer.parseInt(txtEdadUser.getText().toString().trim());
                    String dniUser = txtDNIUser.getText().toString().trim();
                    String celularUser = txtCelularUser.getText().toString().trim();
                    String emailUser = txtEmailUser.getText().toString().trim();

                    if (nombreUser.isEmpty() || apellidoUser.isEmpty() || dniUser.isEmpty() || celularUser.isEmpty() || emailUser.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
                    } else {
                        UpdateUser(nombreUser, apellidoUser, edadUser, dniUser, celularUser, emailUser, id);
                    }
                }
            });
        }
    }

    private void UpdateUser(String nombreUser, String apellidoUser, int edadUser, String dniUser, String celularUser, String emailUser, String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("nombreUser", nombreUser);
        map.put("apellidoUser", apellidoUser);
        map.put("edadUser", edadUser);
        map.put("dniUser", dniUser);
        map.put("celularUser", celularUser);
        map.put("emailUser", emailUser);

        mfirestore.collection("user").document(id).update(map).addOnSuccessListener(unused -> {
            Toast.makeText(getApplicationContext(), "Actualizado exitosamente", Toast.LENGTH_SHORT).show();
            finish();
        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Error al Actualizar", Toast.LENGTH_SHORT).show());
    }

    private void PostUser(String nombreUser, String apellidoUser, int edadUser, String dniUser, String celularUser, String emailUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("nombreUser", nombreUser);
        map.put("apellidoUser", apellidoUser);
        map.put("edadUser", edadUser);
        map.put("dniUser", dniUser);
        map.put("celularUser", celularUser);
        map.put("emailUser", emailUser);

        mfirestore.collection("user").add(map).addOnSuccessListener(documentReference -> {
            Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
            finish();
        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show());
    }

    private void getUser(String id) {
        mfirestore.collection("user").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String nombre = documentSnapshot.getString("nombreUser");
                    String apellido = documentSnapshot.getString("apellidoUser");
                    int edad = documentSnapshot.getLong("edadUser").intValue();
                    String celular = documentSnapshot.getString("celularUser");
                    String correo = documentSnapshot.getString("emailUser");
                    String dni = documentSnapshot.getString("dniUser");

                    txtNombreUser.setText(nombre);
                    txtApellidoUser.setText(apellido);
                    txtEdadUser.setText(String.valueOf(edad));
                    txtDNIUser.setText(dni);
                    txtCelularUser.setText(celular);
                    txtEmailUser.setText(correo);
                }
            }
        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Error al obtener los datos", Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
