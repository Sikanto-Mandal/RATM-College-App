package com.example.ratmstudents;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int checkedItem;
    private String selected;

    private final String CHECKEDITEM = "checked_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("themes", Context.MODE_PRIVATE);
        editor =sharedPreferences.edit();

        switch (getCheckedItem()){
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;

            case 1 :
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;

            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_developer:
                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_rate:
                Toast.makeText(this, "coming soon!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_video:
                Toast.makeText(this, "Video coming soon!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_about:
                Toast.makeText(this, "About coming soon!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_university:


                break;

            case R.id.navigation_website:
                Toast.makeText(this, "College Sites", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_theme:
                Toast.makeText(this, "Themes", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_color:

                showDialog();
                break;

            case R.id.navigation_share:
                Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

    /*
    private void showUniversityWebsite() {
        String[] websites = this.getResources().getStringArray(R.array.website);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Select Website");
        builder.setSingleChoiceItems(R.array.website, getCheckedItem(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected = websites[which];
                checkedItem = which;

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(selected == null){
                    selected = websites[which];
                    checkedItem = which;
                }
                switch (selected){
                    case "AKTU":
                        https://www.google.com
                        break;

                    case "DBRAU" :
                        https://www.google.com

                        break;
                }
                setCheckedItem(checkedItem);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    } */
    private void showDialog() {

        String[] themes = this.getResources().getStringArray(R.array.theme);

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Select Theme");
        builder.setSingleChoiceItems(R.array.theme, getCheckedItem(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                selected = themes[i];
                checkedItem = i;

            }

        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(selected == null){
                    selected = themes[i];
                    checkedItem = i;
                }

                switch (selected){
                    case "System Default":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;

                    case "Dark" :
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;

                    case "Light":
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
                setCheckedItem(checkedItem);

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private int getCheckedItem(){
        return sharedPreferences.getInt(CHECKEDITEM, 0);
    }

    private void setCheckedItem(int i){
        editor.putInt(CHECKEDITEM, i);
        editor.apply();
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
           super.onBackPressed();
    }
}

