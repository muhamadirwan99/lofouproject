package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Hadiah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadiah);
    }

    public void Hadiah1(View view) {
        Intent Hadiah1 = new Intent(Hadiah.this, Hadiah1.class);
        startActivity(Hadiah1);
    }

    public void PostLost(View view) {
        Intent PostLost = new Intent(Hadiah.this, PostLost.class);
        startActivity(PostLost);
    }
}
