package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Hubungi extends AppCompatActivity {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi);

        text =findViewById(R.id.masalah);
    }

    public void Batal(View view){
        Intent Batal = new Intent(Hubungi.this, MainActivity.class);
        startActivity(Batal);
    }

    public void Kirim(View view) {

        String teks = text.getText().toString();

        if(!teks.equals("")){
            Intent Kirim = new Intent(Hubungi.this, Kirim.class);
            startActivity(Kirim);
        }else{
            Toast.makeText(getApplication(), "Tolong isi terlebih dahulu", Toast.LENGTH_SHORT).show();
        }


    }
}
