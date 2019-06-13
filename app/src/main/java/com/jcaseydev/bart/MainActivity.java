package com.jcaseydev.bart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView2);

    // get handle to NavController and setup bottom nav
    NavController navController = Navigation
        .findNavController(MainActivity.this, R.id.nav_host_fragment);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    return false;
  }
}
