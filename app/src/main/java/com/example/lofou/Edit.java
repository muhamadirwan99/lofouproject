package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void UploadF(View view) {
        Intent UploadF = new Intent(Edit.this, UploadF.class);
        startActivity(UploadF);
    }

    public void UbahP(View view) {
        Intent UbahP = new Intent(Edit.this, UbahP.class);
        startActivity(UbahP);
    }

    public void EditProfil(View view) {
        Intent EditProfil = new Intent(Edit.this, MainActivity.class);
        startActivity(EditProfil);
    }
}