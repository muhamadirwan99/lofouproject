package com.example.lofou;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Daftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);

        TextView textView16 = findViewById(R.id.textView16);

        String text = "Persetujuan Syarat dan Ketentuan";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
            }
        };

        ss.setSpan(clickableSpan1,0,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView16.setText(ss);
        textView16.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void Daftar(View view) {
        Intent Daftar = new Intent(Daftar.this, Masuk. class);
        startActivity(Daftar);
    }

    public void Syarat(View view) {
        Intent Syarat = new Intent(Daftar.this, Persetujuan. class);
        startActivity(Syarat);
    }
}
