package com.crrtechnologies;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteController extends SQLiteOpenHelper {

	private static final String LOGCAT = null;
	
	private static final String KEY_ID = "id";
    private static final String KEY_data1 = "data1";
    private static final String KEY_data2 = "data2";
    private static final String KEY_data3 = "datetime";
    
 // Database Name
    private static final String DATABASE_NAME = "SendSMS";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "Demo";
    
    
    
	public SqliteController(Context applicationcontext) {
		 super(applicationcontext, "androidsqlite.db", null, 1);
	     Log.d(LOGCAT,"Created");
	}

	@Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_data1 + " TEXT,"
                + KEY_data2 + " TEXT" + "," + KEY_data3 + " TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	

	void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_data1, contact._data1); // Contact Name
        values.put(KEY_data2, contact._data2); // Contact Phone
        values.put(KEY_data3, contact._data3); // Contact Phone
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }



}
