package com.example.appmovilesunicauca2020.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.appmovilesunicauca2020.R;

import java.io.File;

public class PersistenceSharedPreferences {
    private SharedPreferences mSharePreferences;
    private Context mContext;

    public PersistenceSharedPreferences(SharedPreferences mPreferences, Context mContext) {
        this.mSharePreferences = mPreferences;
        this.mContext = mContext;
    }

    public void createPreferences(){
        File mFile = new File( "/data/data/your_application_package/shared_prefs/"+mContext.getString(R.string.key_mSharePreferences)+".xml");
        if (!mFile.exists()){
            mSharePreferences = mContext.getSharedPreferences(mContext.getString(R.string.key_mSharePreferences), Context.MODE_PRIVATE);
        }
    }

    public void writePreferences(){
        SharedPreferences.Editor mEditor = mSharePreferences.edit();
        mEditor.putBoolean(mContext.getString(R.string.key_register_boolean), true);
        mEditor.apply();
    }
    public boolean readPreferences(){
        boolean valueRegisterBoolean = mSharePreferences.getBoolean(mContext.getString(R.string.key_register_boolean), false);
        return valueRegisterBoolean;
    }

    public void removePreferences(){
        mSharePreferences.edit().clear().apply();
    }
}
