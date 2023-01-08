package com.example.learningpartner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningpartner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register_menu extends AppCompatActivity {
    TextView log;
    EditText inputEmail, pass1, pass2;
    String email, password1, password2;
    Button btnDaftar;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.editTextTextEmailAddress2);
        pass1 = findViewById(R.id.editTextTextPassword);
        pass2 = findViewById(R.id.editTextTextRePassword);
        btnDaftar = findViewById(R.id.buttondaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();
            }
        });
    }

    private void cek_mailpass(String mail, String pass1, String pass2) throws signup_exception {
        if (mail.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            throw new signup_exception("Email atau Password belum diisi");
        }
    }

    private void registrasi() {
        email = inputEmail.getText().toString();
        password1 = pass1.getText().toString();
        password2 = pass2.getText().toString();

        try {
            cek_mailpass(email, password1, password2);
        } catch (signup_exception e){
            System.out.println(e.getMessage());
        } finally {
            if (email.isEmpty() && password1.isEmpty() && password2.isEmpty()){
                Toast.makeText(register_menu.this, "Semua data harus diisi", Toast.LENGTH_LONG).show();
            } else if (email.isEmpty()){
                Toast.makeText(register_menu.this, "Email belum diisi", Toast.LENGTH_LONG).show();
            } else if (password1.isEmpty() || password2.isEmpty()){
                Toast.makeText(register_menu.this, "Password belum diisi", Toast.LENGTH_LONG).show();
            } else if (password1 != password2){
                Toast.makeText(register_menu.this, "Kedua password harus sama", Toast.LENGTH_LONG).show();
            } else {
                mAuth.createUserWithEmailAndPassword(email,password2)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(register_menu.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(register_menu.this, login_menu.class));
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(register_menu.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        }

    }

    public void gotoLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), login_menu.class);
        startActivity(intent);
        finish();
    }
}