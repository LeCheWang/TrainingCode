package com.example.demosqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "CUAHANG";
    static final int DB_VERSION = 1;
    static final String TB_KHACH = "User";

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;

    public SQLHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_KHACH + "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion!=oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TB_KHACH);
            onCreate(db);
        }
    }

    //hàm insert dữ liệu là user và db
    public void insertUser(User user){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());

        sqLiteDatabase.insert(TB_KHACH, null, contentValues);

        sqLiteDatabase.close();
    }

    //lấy toàn bộ users trong db
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TB_KHACH, new String[]{});

        while(cursor.moveToNext()){
            @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));

            users.add(new User(username, password));
        }
        sqLiteDatabase.close();

        return users;
    }
}
