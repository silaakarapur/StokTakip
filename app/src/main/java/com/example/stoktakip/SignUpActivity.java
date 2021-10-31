package com.example.stoktakip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpActivity extends AppCompatActivity {
    Button kayit;
    EditText Ad, soyad, mail, sifre;
    FirebaseAuth firebaseAuth;

    private void initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initFirebaseAuth();
        tanimla();
    }

    private void tanimla() {
        kayit = findViewById(R.id.kayıt);
        Ad = findViewById(R.id.ad);
        soyad = findViewById(R.id.soyad);
        mail = findViewById(R.id.mail);
        sifre = findViewById(R.id.şifre);

        kayit();
    }

    private void kayit() {
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.createUserWithEmailAndPassword(mail.getText().toString(), sifre.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Toast.makeText(SignUpActivity.this,"kayıt işlemi başarılı",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void signIn(View view) {
        Intent intent= new Intent(SignUpActivity.this,SigninActivity.class);
        startActivity(intent);
    }
}