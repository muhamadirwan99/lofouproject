package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LostT3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_t3);
    }

    public void Batal(View view) {
        Intent Batal = new Intent(LostT3.this, MainActivity.class);
        startActivity(Batal);
    }

    public void Next(View view) {
        Intent Next = new Intent(LostT3.this, PostLost.class);
        startActivity(Next);
    }
}
