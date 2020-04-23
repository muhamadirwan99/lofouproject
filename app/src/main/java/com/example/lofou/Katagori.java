package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Katagori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katagori);
    }

    public void PostFound(View view) {
        Intent PostFound = new Intent(Katagori.this, PostFound.class);
        startActivity(PostFound);
    }
}