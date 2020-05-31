package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InfoA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

   public void Ok (View view){
       Intent Ok = new Intent(InfoA.this, MainActivity.class);
       startActivity(Ok);
   }
}
