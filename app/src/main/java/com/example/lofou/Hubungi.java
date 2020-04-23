package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Hubungi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi);
    }

    public void Kirim(View view) {
        Intent Kirim = new Intent(Hubungi.this, Kirim.class);
        startActivity(Kirim);
    }
}
