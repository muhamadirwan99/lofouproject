package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FoundT2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_t2);
    }
    public void batal(View view) {
        Intent batal = new Intent(FoundT2.this, MainActivity.class);
        startActivity(batal);
    }

    public void Next(View view) {
        Intent Next = new Intent(FoundT2.this, PostFound.class);
        startActivity(Next);
    }
}
