package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Utama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);
    }

    public void Masuk(View view) {
        Intent Masuk = new Intent(Utama.this, Masuk. class);
        startActivity(Masuk);
    }


    public void Daftar (View view) {
        startActivity(new Intent(Utama.this,Daftar.class));
    }
}
