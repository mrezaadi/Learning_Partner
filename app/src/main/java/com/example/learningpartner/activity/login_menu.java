package com.example.learningpartner.activity;

import  androidx.annotation.NonNull;
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

public class login_menu extends AppCompatActivity {
    TextView reg;
    private EditText inputEmail, inputPassword;
    private String email, password;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.editTextTextEmailAddress2);
        inputPassword = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
                cekLogin();
            }
        });
        reg = (TextView)findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_menu.this, register_menu.class));
            }
        });
    }

    public void gotoMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), main_menu.class);
        startActivity(intent);
        finish();
    }

    public void gotoRegister(View view) {
        Intent intent = new Intent(getApplicationContext(), register_menu.class);
        startActivity(intent);
        finish();
    }

    private void cek_mailpass(String mail, String pass) throws login_exception {
        if (mail.isEmpty() || pass.isEmpty()){
            throw new login_exception("Email atau Password belum diisi");
        }
    }


    private void cekLogin() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        try{
            cek_mailpass(email, password);
        } catch (login_exception e){
            System.out.println(e.getMessage());
        } finally{
            if (email.isEmpty() && password.isEmpty()){
                Toast.makeText(login_menu.this, "Email dan Password belum diisi", Toast.LENGTH_LONG).show();
            } else if (email.isEmpty()){
                Toast.makeText(login_menu.this, "Email belum diisi", Toast.LENGTH_LONG).show();
            } else if (password.isEmpty()) {
                Toast.makeText(login_menu.this, "Password belum diisi", Toast.LENGTH_LONG).show();
            } else {
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(login_menu.this, "Login Sukses", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(login_menu.this, main_menu.class));
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(login_menu.this, "Login Gagal, email atau password anda salah", Toast.LENGTH_LONG).show();
                                }
                            }

                        });
            }

        }

    }

}