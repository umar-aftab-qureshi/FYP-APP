package com.example.iqp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserInformation.db";
    private static final String User_TABLE = "Users";
    //private static final String KEY_ID = "id";
    private static final String Email = "Email";
    private static final String User_name = "UserName";
    private static final String Password = "password";
//    String CREATE_User_TABLE = "CREATE TABLE " + User_TABLE + "("
//            + KEY_ID + " INTEGER PRIMARY KEY," + Email + " TEXT,"



    String q= "Create table Users (Email Text,UserName Text  Primary key , password TEXT )";

    public DataBaseHandler(@Nullable Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + User_TABLE);

        //Create tables again
        onCreate(db);

    }
    //Adding information to the database
    public Boolean addInformation(Users users)
    {
        Boolean result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User_name,users.getUsername());
        values.put(Email,users.getEmail());
        values.put(Password,users.getPassword());
        long id = db.insert(User_TABLE,null,values);
        db.close();
        if (id== -1)
        {
            result = false;
        }
        else
        {
            result = true;
        }
        return  result;
    }
    //Getting all the users data that is stored in the databse
//    public List<Users> getContacts()
//    {
//        List<Users> userlist = new ArrayList<Users>();
//        String selectQuery = "SELECT  * FROM " + User_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery,null);
//        //Looping all the rows
//        if (cursor.moveToNext())
//        {
//            do
//            {
//                Users users = new Users();
//                users.setEmail(cursor.getString(0));
//                users.setUsername(cursor.getString(1));
//                users.setPassword(cursor.getString(2));
//                // Adding contact to list
//                userlist.add(users);
//            } while (cursor.moveToNext());
//        }
//        // return contact list
//        return userlist;
//
//
//    }
    public Boolean isLogged(String Username1, String passwords)
    {
        boolean choice = false;
        SQLiteDatabase db = this.getReadableDatabase();
        String[] col = {User_name};
        String selection = User_name + "=?" + " and " + Password + " =?";
        String [] selectionArguments = {Username1, passwords};
        Cursor cursor = db.query(User_TABLE,col,selection,selectionArguments,null,null,null);
        choice = cursor.getCount() > 0;//True
        return choice;
    }
    }

