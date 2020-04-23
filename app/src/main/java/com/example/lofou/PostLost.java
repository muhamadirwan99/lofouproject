package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PostLost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_lost);
    }

    public void Katagori(View view) {
        Intent Katagori = new Intent(PostLost.this, Katagori.class);
        startActivity(Katagori);
    }

    public void UploadFoto(View view) {
        Intent  UploadFoto = new Intent(PostLost.this, UploadFotoLost.class);
        startActivity(UploadFoto);
    }

    public void LostT1(View view) {
        Intent  LostT1 = new Intent(PostLost.this, LostT1.class);
        startActivity(LostT1);
    }

    public void Hadiah(View view) {
        Intent  Hadiah = new Intent(PostLost.this, Hadiah.class);
        startActivity(Hadiah);
    }
}
