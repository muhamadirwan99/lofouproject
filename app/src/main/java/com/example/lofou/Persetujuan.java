package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Persetujuan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persetujuan);
    }

    public void Ok(View view) {
        Intent Ok = new Intent(Persetujuan.this, Daftar. class);
        startActivity(Ok);
    }
}
