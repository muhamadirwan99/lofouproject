package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Masuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masuk);
    }

    public void Lanjut(View view) {
        Intent Lanjut = new Intent(Masuk.this, MainActivity. class);
        startActivity(Lanjut);
    }
}
