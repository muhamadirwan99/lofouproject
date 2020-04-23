package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UbahP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_p);
    }

    public void Edit(View view) {
        Intent Edit = new Intent(UbahP.this, Edit.class);
        startActivity(Edit);

    }

    public void Berhasil(View view) {
        Intent Berhasil = new Intent(UbahP.this,Sukses.class);
        startActivity(Berhasil);
    }
}
