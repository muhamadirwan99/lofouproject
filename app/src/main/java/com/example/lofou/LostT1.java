package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LostT1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_t1);
    }

    public void batal(View view) {
        Intent batal = new Intent(LostT1.this, MainActivity.class);
        startActivity(batal);
    }

    public void Next(View view) {
        Intent Next = new Intent(LostT1.this, LostT2.class);
        startActivity(Next);
    }
}
