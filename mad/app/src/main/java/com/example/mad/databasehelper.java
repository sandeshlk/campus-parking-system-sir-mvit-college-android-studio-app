package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class databasehelper extends SQLiteOpenHelper {
    List<User> Users = new ArrayList<>();
    int avail,tot,Cid;

    public databasehelper(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PARKING(PARKING_LOT INTEGER PRIMARY KEY,TOTAL_SLOTS INTEGER,AVAIL_SLOTS INTEGER) ");
        db.execSQL("INSERT INTO PARKING values (1,44,2)");
        db.execSQL("INSERT INTO PARKING values (2,120,22)");
        db.execSQL("INSERT INTO PARKING values (3,30,6)");
        db.execSQL("INSERT INTO PARKING values (4,15,9)");
        db.execSQL("INSERT INTO PARKING values (5,25,5)");
        db.execSQL("INSERT INTO PARKING values (6,52,6)");
        }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists PARKING");
        onCreate(db);
        }

public int ReadRecords(int id) {
        try {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  PARKING ", null);
        while (cursor.moveToNext()) {
            Cid = cursor.getInt(0);
            tot = cursor.getInt(1);
            avail = cursor.getInt(2);
            if(Cid==id)break;

        }
        }
        catch (Exception ex){}
        return avail;
    }
    public int WriteRecords(int avail, int id) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("AVAIL_SLOTS", avail);
            String whereClause = "PARKING_LOT = ?";
            String[] whereArgs = {String.valueOf(id)};
            int rowsAffected = db.update("PARKING", values, whereClause, whereArgs);
            return rowsAffected;
        } catch (Exception ex) {
            return 0;
        }
    }


}