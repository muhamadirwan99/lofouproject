package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Daftar extends AppCompatActivity {

    EditText Nama, NIM, Email, Nohp, Password, uPassword;
    Button bDaftar;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);

        Nama = findViewById(R.id.nama);
        NIM = findViewById(R.id.nim);
        Email = findViewById(R.id.email);
        Nohp = findViewById(R.id.nohp);
        Password = findViewById(R.id.pw);
        uPassword = findViewById(R.id.kpw);
        bDaftar = findViewById(R.id.daftar);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);



        bDaftar.setOnClickListener(new View.OnClickListener() {
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

                // register

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Daftar.this,"Akun telah dibuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Masuk.class));

                        }else{
                            Toast.makeText(Daftar.this,"Gagal membuat akun"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


        TextView textView16 = findViewById(R.id.textView16);

        String text = "Persetujuan Syarat dan Ketentuan";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
            }
        };

        ss.setSpan(clickableSpan1,0,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView16.setText(ss);
        textView16.setMovementMethod(LinkMovementMethod.getInstance());
    }




  /*  public void Daftar(View view) {
        Intent Daftar = new Intent(Daftar.this, Masuk. class);
        startActivity(Daftar);
    }*/

    public void Syarat(View view) {
        Intent Syarat = new Intent(Daftar.this, Persetujuan. class);
        startActivity(Syarat);
    }
}
