package com.nsc.nsc.nscdatabase.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

import static com.nsc.nsc.nscdatabase.DBUtils.*;

/**
 * Created by rippy3402 on 19-07-2017.
 */

public class DesignNamesOnlyTable {
    public static final String TAG="DESIGN NAME ADDED";

    public static class DesignNamesOnlyColumns implements BaseColumns
    {
        public static final String DESIGNS_ONLY_TABLE_NAME="designnamesonly";
        public static final String DESIGN_ONLY_COLUMN_id="id";
        public static final String DESIGN_ONLY_COLUMN_NAME="designname";


    }

    public static final String CMD_CREATE_TABLE_DESIGN_ONLY=
            CREATE_TABLE +
            DesignNamesOnlyColumns.DESIGNS_ONLY_TABLE_NAME +
            LBR +
            DesignNamesOnlyColumns.DESIGN_ONLY_COLUMN_id +
            TYPE_INTEGER_PK_AI +
            COMMA +
            DesignNamesOnlyColumns.DESIGN_ONLY_COLUMN_NAME +
            TYPE_TEXT +
            RBR +
            SEMI;
     public static void addDesignOnly(SQLiteDatabase db,String desingname)
     {
         Log.d(TAG, "addDesignOnly: "+desingname);
         ContentValues contentValues=new ContentValues();
         contentValues.put(DesignNamesOnlyColumns.DESIGN_ONLY_COLUMN_NAME,desingname);
         long id=db.insert(DesignNamesOnlyColumns.DESIGNS_ONLY_TABLE_NAME,null,contentValues);
         Log.d(TAG, "Id of design table "+id);

     }
     public static ArrayList<String> getDesignNames(SQLiteDatabase db)
     {
         Cursor c=db.query(DesignNamesOnlyColumns.DESIGNS_ONLY_TABLE_NAME,new String[]{DesignNamesOnlyColumns.DESIGN_ONLY_COLUMN_NAME},
                 null,
                 null,
                 null,
                 null,
                 null);
         ArrayList<String> arrayListDesignNames =new ArrayList<>();

         int index=c.getColumnIndex(DesignNamesOnlyColumns.DESIGN_ONLY_COLUMN_NAME);
         while(c.moveToNext())
         {
             arrayListDesignNames.add(c.getString(index));
         }
         return arrayListDesignNames;
     }


}
