package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PostFound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_found);
    }

    public void Terimakasih(View view) {
        Intent Terimakasih = new Intent(PostFound.this, Terimakasih.class);
        startActivity(Terimakasih);
    }

    public void UploadFoto(View view) {
        Intent UploadFoto = new Intent(PostFound.this, UploadFoto.class);
        startActivity(UploadFoto);
    }

    public void Katagori(View view) {
        Intent Katagori = new Intent(PostFound.this, Katagori.class);
        startActivity(Katagori);
    }

    public void FoundT1(View view) {
        Intent FoundT1 = new Intent(PostFound.this, FoundT1.class);
        startActivity(FoundT1);
    }
}