package com.example.appmovilesunicauca2020.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appmovilesunicauca2020.model.RegisterUserModel;

import java.util.ArrayList;

public class PersistenciaSqlite extends SQLiteOpenHelper {
    private static final String NAME_DATABASE = "RegisterDB";
    private static String KEY_TABLE_NAME = "RegisterUser";
    private static String KEY_ID = "id";
    private static String KEY_NAME_USER = "name_user";
    private static String KEY_MAIL_USER = "mail_user";
    private static String KEY_PHONE_USER = "num_phone";
    private static String KEY_PASSWORD_USER = "password";

    private static final String SQLRegister = "CREATE TABLE RegisterUser(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name_user TEXT, " +
            "mail_user TEXT, " +
            "num_phone TEXT, " +
            "password TEXT)";

    public PersistenciaSqlite(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NAME_DATABASE, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLRegister);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    SQLiteDatabase dbRegister;

    public void openDB(boolean write) {
        if (write) {
            dbRegister = this.getWritableDatabase();
        } else {
            dbRegister = this.getReadableDatabase();
        }
    }

    public void closeDB() {
        dbRegister.close();
    }

    //CRUD

    public long createUser(RegisterUserModel userModel) {
        openDB(true);
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(KEY_NAME_USER, userModel.getNameUser());
        mContentValues.put(KEY_MAIL_USER, userModel.getMailUser());
        mContentValues.put(KEY_PHONE_USER, userModel.getPhoneUser());
        mContentValues.put(KEY_PASSWORD_USER, userModel.getPassUser());
        long valueDb = dbRegister.insert(KEY_TABLE_NAME, null, mContentValues);
        closeDB();
        return valueDb;
    }

    public ArrayList<RegisterUserModel> readFullUsers() {
        openDB(false);
        String select = "SELECT * FROM " + KEY_TABLE_NAME;
        ArrayList<RegisterUserModel> listUser = new ArrayList<>();
        Cursor cursorRegister = dbRegister.rawQuery(select, null);
        if (cursorRegister.moveToFirst() && cursorRegister != null) {
            do {
                int idUser = cursorRegister.getInt(0);
                String nameUser = cursorRegister.getString(1);
                String mailUser = cursorRegister.getString(2);
                String phoneUser = cursorRegister.getString(3);
                String passUser = cursorRegister.getString(4);

                RegisterUserModel mModeRegister = new RegisterUserModel(idUser, nameUser,
                                                                mailUser, phoneUser, passUser);
                listUser.add(mModeRegister);
            } while (cursorRegister.moveToNext());
        }
        close();
        return listUser;
    }

    public String readPassOfMail(String mail) {
        openDB(false);
        String mSelect = "SELECT " + KEY_PASSWORD_USER + " FROM " + KEY_TABLE_NAME +
                         " WHERE " + KEY_MAIL_USER + " = ?";
        String[] args = {mail};
        Cursor mCursor = dbRegister.rawQuery(mSelect, args);
        String passUser = null;
        if (mCursor != null && mCursor.moveToFirst()) {
            passUser = mCursor.getString(0);
        }
        closeDB();
        return passUser;
    }

    public long updatePhone(int id, String newPhone) {
        openDB(true);
        ContentValues mCV = new ContentValues();
        mCV.put(KEY_PHONE_USER, newPhone);
        String clause = KEY_ID + "=" + id;
        long retu = dbRegister.update(KEY_TABLE_NAME, mCV, clause, null);
        closeDB();
        return retu;
    }

    public long deleteUser(int id) {
        openDB(false);
        String clause = KEY_ID + "=" + id;
        long retu = dbRegister.delete(KEY_TABLE_NAME, clause, null);
        closeDB();
        return retu;
    }

}
