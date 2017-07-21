package com.nsc.nsc.nscdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.nsc.nsc.nscdatabase.tables.CarsTable.*;
import static com.nsc.nsc.nscdatabase.tables.DesignsTable.*;
import static com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable.*;

/**
 * Created by rippy3402 on 17-07-2017.
 */

public class MyNscDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "nsc.db";
    public static final int DB_VER = 1;
    public static final String TAG="TAG HELPER";
    public MyNscDatabaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CMD_CREATE_TABLE_CARTABLE);
        db.execSQL(CMD_CREATE_TABLE_DESIGNTABLE);
        db.execSQL(CMD_CREATE_TABLE_DESIGN_ONLY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
