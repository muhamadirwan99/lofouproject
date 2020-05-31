package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kirim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim);
    }

    public void Oke(View view){
        Intent Oke = new Intent(Kirim.this, MainActivity.class);
        startActivity(Oke);
    }
}
