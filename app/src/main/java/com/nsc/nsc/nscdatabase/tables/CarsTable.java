package com.nsc.nsc.nscdatabase.tables;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;

import java.util.ArrayList;

import static com.nsc.nsc.nscdatabase.DBUtils.*;



/**
 * Created by rippy3402 on 18-07-2017.
 */

public class CarsTable {
    private CarsTable() {}
    public static final String TAG="ID";


    public static class CarsTableColumns implements BaseColumns{
        public static final String TABLE_NAME= "cars";
        public static final String COLUMN_id= "id";
        public static final String COLUMN_CARNAME= "carname";

    }

    public static final String CMD_CREATE_TABLE_CARTABLE =
                    CREATE_TABLE +
                    CarsTableColumns.TABLE_NAME +
                    LBR +
                    CarsTableColumns.COLUMN_id +
                    TYPE_INTEGER_PK_AI +
                    COMMA +
                    CarsTableColumns.COLUMN_CARNAME +
                    TYPE_TEXT +
                    RBR +
                    SEMI;


    public static void addCarName (SQLiteDatabase db, String carName)
    {
        Log.d(TAG, "addCarName: "+carName);

        ContentValues cartoInsert = new ContentValues();

        cartoInsert.put(CarsTableColumns.COLUMN_CARNAME,carName);

        Long id = db.insert(CarsTableColumns.TABLE_NAME,null,cartoInsert);


        Log.d(TAG, "Id of car table "+id);


    }
    public static ArrayList<Long> getIds(SQLiteDatabase db)

    {
        Cursor c=db.query(CarsTableColumns.TABLE_NAME,new String []{CarsTableColumns.COLUMN_id},
        null,null,null,null,null
        );
      ArrayList<Long> arraylistIds =new ArrayList<>();

      int index=c.getColumnIndex(CarsTableColumns.COLUMN_id);
        while (c.moveToNext())
        {
            arraylistIds.add(c.getLong(index));
        }



    return arraylistIds;
    }
   public static ArrayList<String> getCarNames(SQLiteDatabase db)
   {

        Cursor c=db.query(CarsTableColumns.TABLE_NAME,new String[]{CarsTableColumns.COLUMN_CARNAME},
                null,null,null,null,null);

       ArrayList<String> arrayListCarNames=new ArrayList<>();

       int index=c.getColumnIndex(CarsTableColumns.COLUMN_CARNAME);
       while (c.moveToNext())
       {
           arrayListCarNames.add(c.getString(index));
       }

       return arrayListCarNames;
   }

}