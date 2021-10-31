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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {
    Button giris;
    EditText mail, Sifre;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private void initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initFirebaseAuth();

        tanimlama();
    }

    public void tanimlama() {
        giris = findViewById(R.id.girisbuton);
        mail = findViewById(R.id.kullaniciview);
        Sifre = findViewById(R.id.sifteview);
        giris();
    }

    private void giris() {
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(mail.getText().toString(), Sifre.getText().toString()).addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
setContentView(R.layout.activity_main);
                            Toast.makeText(SigninActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                        }

                        else
                            Toast.makeText(SigninActivity.this,"Tekrar Deneyiniz",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }


    public void createAccount(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}