package com.example.actualdatabaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mitch on 2016-05-13.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";
    ContentValues contentValues = new ContentValues();



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM1 TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    SQLiteDatabase db;
    public boolean addData(String item1) {
        db = this.getWritableDatabase();
        contentValues.put(COL2, item1);

        Log.i("wow", String.valueOf(contentValues));

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        return result != -1;
    }

//    public ArrayList<String> getSpecificColumn(String book) {
//        ArrayList<String> AUTHOR_ARRAYLIST;
//        AUTHOR_ARRAYLIST = new ArrayList<String>();
//
//        db = getWritableDatabase;
//        String WHERE = Book + "=" + book;
//        Cursor cursor = db.query(BookAuthor_TAB, BookAuthor_AllKeys, WHERE, null, null, null, null);
//
//        while(cursor.moveToNext())
//        {
//            String AUTHOR = cursor.getString(cursor.getColumnIndex(Author));
//            AUTHOR_ARRAYLIST.add(AUTHOR);
//        }
//
//        return AUTHOR_ARRAYLIST;
//    }



    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}