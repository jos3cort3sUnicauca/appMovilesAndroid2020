package com.example.appmovilesunicauca2020.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.appmovilesunicauca2020.R;
import com.example.appmovilesunicauca2020.persistence.PersistenceSharedPreferences;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mSharePreferences;
    private PersistenceSharedPreferences mSharePreferencesClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharePreferencesClass = new PersistenceSharedPreferences(mSharePreferences, this);
        mSharePreferencesClass.createPreferences();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_perfil:
                break;
            case R.id.menu_Logout:
                mSharePreferencesClass.removePreferences();
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}