package com.example.lofou;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private void init() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        navController = Navigation.findNavController(this,R.id.main);
        appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.lost,R.id.search,R.id.found,R.id.filterfound,R.id.filterlost})
                .setDrawerLayout(drawer)
                .build();
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration );
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void lost (MenuItem item) {
        Intent lofou = new Intent(MainActivity.this, LostT1.class);
        startActivity(lofou);
    }

    public void found (MenuItem item) {
        Intent found = new Intent(MainActivity.this, FoundT1.class);
        startActivity(found);
    }

    public void riwayatLost (MenuItem item) {
        Intent riwayatLost = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(riwayatLost);
    }

    public void riwayatFound (MenuItem item) {
        Intent riwayatFound = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(riwayatFound);
    }

    public void hubungi (MenuItem item) {
        Intent hubungi = new Intent(MainActivity.this, Hubungi.class);
        startActivity(hubungi);
    }

    public void info (MenuItem item) {
        Intent info = new Intent(MainActivity.this, InfoA.class);
        startActivity(info);
    }

    public void syaratKetentuan (MenuItem item) {
        Intent syaratKetentuan = new Intent(MainActivity.this, SK.class);
        startActivity(syaratKetentuan);
    }

    public void editProfil(View view) {
        Intent editProfil = new Intent(MainActivity.this, EditProfil.class);
        startActivity(editProfil);
    }
}
