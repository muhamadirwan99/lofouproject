package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Masuk extends AppCompatActivity {

    EditText Email, Password;
    Button masuktmbl;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masuk);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.pw);
        progressBar = findViewById(R.id.progressBar2);
        masuktmbl = findViewById(R.id.login);
        fAuth = FirebaseAuth.getInstance();

        masuktmbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Email dibutuhkan");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("Password dibutuhkan");
                    return;
                }

                if(password.length() < 6){
                    Password.setError("Password harus lebih dari 6 karaktwe");
                }

                progressBar.setVisibility(View.VISIBLE);

                // authentication

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Masuk.this,"Telah berhasil masuk", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Masuk.this,"Gagal masuk"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
