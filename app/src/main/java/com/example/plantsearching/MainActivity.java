package com.example.plantsearching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.plantsearching.Fragment.HomeFragment;
import com.example.plantsearching.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, HomeFragment.class,null);
        fragmentTransaction.commit();

        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setBackground(null);
        bottomNav.setItemIconTintList(null);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleChangeFragment(item.getItemId());
                return true;
            }
        });
    }

    private void handleChangeFragment(int itemId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(itemId == R.id.nav_home){
            fragmentTransaction.replace(R.id.fragment_container, HomeFragment.class,null);
        }
        if(itemId == R.id.nav_profile){
            fragmentTransaction.replace(R.id.fragment_container, ProfileFragment.class,null);
        }
        fragmentTransaction.commit();
    }
}