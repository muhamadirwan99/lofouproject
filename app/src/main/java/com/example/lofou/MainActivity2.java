package com.example.lofou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        bottomNavigationView = findViewById(R.id.bottomNav);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new LostRiwayatFragment2()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.riwayat:
                        fragment = new LostRiwayatFragment2();
                        break;
                    case R.id.search:
                        fragment = new FoundFragment();
                        break;
                    case R.id.filter:
                        fragment = new LostRiwayatFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }

    public void ImageFragment (View view) {
        Intent ImageFragment = new Intent(MainActivity2.this, ImageFragment.class);
        startActivity(ImageFragment);
    }

    public void ImageRewardFragment (View view) {
        Intent ImageRewardFragment = new Intent(MainActivity2.this, ImageRewardFragment.class);
        startActivity(ImageRewardFragment);
    }
}
