package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Terimakasih extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terimakasih);
    }

    public void PostFound(View view) {
        Intent PostFound = new Intent(Terimakasih.this, PostFound.class);
        startActivity(PostFound);

    }
}
