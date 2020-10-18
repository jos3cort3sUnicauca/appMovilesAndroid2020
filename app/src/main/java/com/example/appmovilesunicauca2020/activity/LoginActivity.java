package com.example.appmovilesunicauca2020.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import com.example.appmovilesunicauca2020.R;
import com.example.appmovilesunicauca2020.fragment.LoginFragment;
import com.example.appmovilesunicauca2020.fragment.RegisterFragment;
import com.example.appmovilesunicauca2020.persistence.PersistenceSharedPreferences;

public class LoginActivity extends AppCompatActivity implements LoginFragment.MyOnEventListener {

    private PersistenceSharedPreferences mSharePreferencesClass;
    private SharedPreferences mSharePreferences;
    private String mailDb = "joseluiscortes@unicauca.edu.co",
                   passDb = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        SystemClock.sleep(1000);
        setContentView(R.layout.activity_login);
        LoginFragment fragLogin = new LoginFragment();
        addFragment(fragLogin);
        mSharePreferencesClass = new PersistenceSharedPreferences(mSharePreferences, this);
        mSharePreferencesClass.createPreferences();
        automaticLogin();
    }

    private void addFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_Login_Register, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_Login_Register, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void automaticLogin(){
        if(mSharePreferencesClass.readPreferences()){
            Intent goMainAutomatic =  new Intent(this, MainActivity.class);
            startActivity(goMainAutomatic);
            finish();
        }
    }

    @Override
    public void onEventButtons(int idButton) {

       switch (idButton){
           case R.id.btn_forgotten_login:
               break;

           case R.id.btn_register:
               RegisterFragment fragRegister =  new RegisterFragment();
               replaceFragment(fragRegister);
               break;

           default:
               break;
       }
    }
    @Override
    public void onEventButtons(int idButton, String [] valuesEditText, boolean checkedRemember) {
        switch (idButton){
            case R.id.btn_login:
                if (checkedRemember){
                    if(mailDb.equals(valuesEditText[0]) && passDb.equals(valuesEditText[1])){
                        mSharePreferencesClass.writePreferences();
                        Toast.makeText(this, "Welcome to EnterThing", Toast.LENGTH_LONG).show();
                        Intent mIntent =  new Intent(this, MainActivity.class);
                        startActivity(mIntent);
                        finish();
                    }else{
                        Toast.makeText(this, "Mail and Pass no found", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (mailDb.equals(valuesEditText[0]) && passDb.equals(valuesEditText[1])) {
                        Toast.makeText(this, "Welcome to EnterThing", Toast.LENGTH_LONG).show();
                        Intent mIntent = new Intent(this, MainActivity.class);
                        startActivity(mIntent);
                        finish();
                    } else {
                        Toast.makeText(this, "Mail and Pass no found", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }

    }
}