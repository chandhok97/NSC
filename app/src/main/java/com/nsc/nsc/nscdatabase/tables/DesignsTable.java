package com.nsc.nsc.nscdatabase.tables;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

import static com.nsc.nsc.nscdatabase.DBUtils.*;
import static com.nsc.nsc.nscdatabase.tables.CarsTable.*;
import static com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable.*;

/**
 * Created by rippy3402 on 19-07-2017.
 */

public class DesignsTable {

   public static final String TAG="DESIGN SNO";


    public static class DesignsTableColumns implements BaseColumns
    {
        public static final String DESIGN_TABLE_NAME="designs";
        public static final String DESIGN_COLUMN_id="id";
        public static final String COLUMN_DESIGN="design";
        public static final String COLUMN_TOTALQUANTITY="totalquantity";
        public static final String COLUMN_VINOD="vinodquantity";
        public static final String COLUMN_DHARAMPAL="dharampalquantity";
        public static final String COLUMN_ANIL="anilquantity";
        public static final String COLUMN_PINTO="pintoquantity";
        public static final String COLUMN_MOHAMMAD="mohammadquantity";
    }

    public static final String CMD_CREATE_TABLE_DESIGNTABLE=
            CREATE_TABLE +
            DesignsTableColumns.DESIGN_TABLE_NAME +
            LBR +
            DesignsTableColumns.DESIGN_COLUMN_id +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_DESIGN +
            TYPE_TEXT +
            COMMA +
            DesignsTableColumns.COLUMN_ANIL +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_DHARAMPAL +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_MOHAMMAD +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_PINTO +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_VINOD +
            TYPE_INTEGER +
            COMMA +
            DesignsTableColumns.COLUMN_TOTALQUANTITY +
            TYPE_INTEGER +
            RBR +
            SEMI;

    public static void addToDesignTableNewDesign(SQLiteDatabase db,String designName)
    {

        ArrayList<Long> arrayListCarsId=CarsTable.getIds(db);
        for(int i=0;i<arrayListCarsId.size();++i)
        {
            ContentValues contentValues=new ContentValues();
            contentValues.put(DesignsTableColumns.DESIGN_COLUMN_id,i+1);
            contentValues.put(DesignsTableColumns.COLUMN_DESIGN,designName);
            contentValues.put(DesignsTableColumns.COLUMN_ANIL,0);
            contentValues.put(DesignsTableColumns.COLUMN_DHARAMPAL,0);
            contentValues.put(DesignsTableColumns.COLUMN_MOHAMMAD,0);
            contentValues.put(DesignsTableColumns.COLUMN_PINTO,0);
            contentValues.put(DesignsTableColumns.COLUMN_VINOD,0);
            contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,0);
            long id= db.insert(DesignsTableColumns.DESIGN_TABLE_NAME,null,contentValues);

            Log.d(TAG, "Index + Id + DesignMane " + id +(i+1) + designName);
        }

    }


    public static void addToExistingDesigns(SQLiteDatabase db)
    {

        ArrayList<String> arrayListDesignNames=DesignNamesOnlyTable.getDesignNames(db);
        ArrayList<Long> arrayListCarsId=CarsTable.getIds(db);
        int index=arrayListCarsId.size();

        for (int i=0;i<arrayListDesignNames.size();++i)
        {
            ContentValues contentValues=new ContentValues();
            contentValues.put(DesignsTableColumns.DESIGN_COLUMN_id,index);
            contentValues.put(DesignsTableColumns.COLUMN_DESIGN,arrayListDesignNames.get(i));
            contentValues.put(DesignsTableColumns.COLUMN_ANIL,0);
            contentValues.put(DesignsTableColumns.COLUMN_DHARAMPAL,0);
            contentValues.put(DesignsTableColumns.COLUMN_MOHAMMAD,0);
            contentValues.put(DesignsTableColumns.COLUMN_PINTO,0);
            contentValues.put(DesignsTableColumns.COLUMN_VINOD,0);
            contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,0);

            long id=  db.insert(DesignsTableColumns.DESIGN_TABLE_NAME,null,contentValues);
            Log.d(TAG, "Index + id + design " + id + index + arrayListDesignNames.get(i));
        }

    }

   public static ArrayList<Integer> getTotalQuanties(SQLiteDatabase db,int id)
   {
      // Cursor c=db.query
      //         (DesignsTableColumns.DESIGN_TABLE_NAME +" , " +CarsTableColumns.TABLE_NAME,
      //                new String[]{DesignsTableColumns.COLUMN_TOTALQUANTITY },
      //                 CarsTableColumns.TABLE_NAME + " ." + CarsTableColumns.COLUMN_id+ " = " +
      //                 DesignsTableColumns.DESIGN_TABLE_NAME+ " ." + DesignsTableColumns.DESIGN_COLUMN_id,
                 //      + " AND " +DesignsTableColumns.DESIGN_COLUMN_id + " = "+ id,
        //               null,
       //                null,
        //               null,
          //             null

      // );

       Cursor c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                        new String[] {DesignsTableColumns.COLUMN_TOTALQUANTITY},
                        DesignsTableColumns.DESIGN_COLUMN_id+ " = " + id,
                        null,
                        null,
                        null,
                        null
               );

       ArrayList<Integer> arrayListTotalQuantities=new ArrayList<>();

       int index=c.getColumnIndex(DesignsTableColumns.COLUMN_TOTALQUANTITY);

       while (c.moveToNext())
       {
           arrayListTotalQuantities.add(c.getInt(index));
       }



       return arrayListTotalQuantities;
   }

   public static ArrayList<Integer> getContQuantities(SQLiteDatabase db,int id,String name)
   {
       Cursor c;
       ArrayList<Integer> arrayListContQuantities=new ArrayList<>();
       switch (name)
       {
           case "Anil":
           {

               c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                       new String[]{DesignsTableColumns.COLUMN_ANIL},
                       DesignsTableColumns.DESIGN_COLUMN_id+" = " + id,
                       null,
                       null,
                       null,
                       null
               );
               int index=c.getColumnIndex(DesignsTableColumns.COLUMN_ANIL);

               while (c.moveToNext())
               {
                   arrayListContQuantities.add(c.getInt(index));
               }

               break;
           }

           case "Dharampal":
           {

               c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                          new String[]{DesignsTableColumns.COLUMN_DHARAMPAL},
                          DesignsTableColumns.DESIGN_COLUMN_id+" = "+id,
                          null,
                       null,
                       null,null
                       );
               int index=c.getColumnIndex(DesignsTableColumns.COLUMN_DHARAMPAL);

               while (c.moveToNext())
               {
                   arrayListContQuantities.add(c.getInt(index));
               }

               break;
           }

           case "Mohammad":
           {

               c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                       new String[]{DesignsTableColumns.COLUMN_MOHAMMAD},
                       DesignsTableColumns.DESIGN_COLUMN_id+ " = " +id,
                       null,
                       null,
                       null,null
                       );

               int index=c.getColumnIndex(DesignsTableColumns.COLUMN_MOHAMMAD);

               while (c.moveToNext())
               {

                   arrayListContQuantities.add(c.getInt(index));
               }

               break;
           }

           case "Pinto":
           {

               c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                       new String[]{DesignsTableColumns.COLUMN_PINTO},
                       DesignsTableColumns.DESIGN_COLUMN_id+" = "+id,
                       null,null,null,null
                       );

               int index=c.getColumnIndex(DesignsTableColumns.COLUMN_PINTO);

               while (c.moveToNext())
               {
                   arrayListContQuantities.add(c.getInt(index));
               }

               break;
           }

           case "Vinod":
           {

               c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,
                       new String[]{DesignsTableColumns.COLUMN_VINOD},
                       DesignsTableColumns.DESIGN_COLUMN_id+" = "+id,
                       null,null,null,null
                       );

               int index=c.getColumnIndex(DesignsTableColumns.COLUMN_VINOD);

               while (c.moveToNext())
               {
                   arrayListContQuantities.add(c.getInt(index));
               }
             break;

           }

       }

      return arrayListContQuantities;

   }

   public static void updateQuantities(SQLiteDatabase db,int id,String name,int quantity,String designName,int initQuan,int continit)
   {
      switch (name)
      {
          case "Anil":
          {

              ContentValues contentValues=new ContentValues();
              contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,initQuan+quantity);
              contentValues.put(DesignsTableColumns.COLUMN_ANIL,initQuan+quantity);

              db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                      contentValues,
                      DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                              + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+designName+"'" ,
                      null
                      );
          break;
          }

          case "Dharampal":
          {

              ContentValues contentValues=new ContentValues();
              contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,initQuan+quantity);
              contentValues.put(DesignsTableColumns.COLUMN_DHARAMPAL,continit+quantity);

              db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                      contentValues,
                      DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                              + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+designName+"'" ,
                      null
                      );
          break;
          }
          case "Mohammad":
          {

              ContentValues contentValues=new ContentValues();
              contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,initQuan+quantity);
              contentValues.put(DesignsTableColumns.COLUMN_MOHAMMAD,continit+quantity);

              db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                      contentValues,
                      DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                              + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+designName+"'" ,
                      null
              );
          break;
          }

          case "Pinto":
          {

              ContentValues contentValues=new ContentValues();
              contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,initQuan+quantity);
              contentValues.put(DesignsTableColumns.COLUMN_PINTO,continit+quantity);

              db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                      contentValues,
                      DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                              + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+designName+"'" ,
                      null
              );
         break;

          }

          case "Vinod":
          {

              ContentValues contentValues=new ContentValues();
              contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,initQuan+quantity);
              contentValues.put(DesignsTableColumns.COLUMN_VINOD,continit+quantity);

              db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                      contentValues,
                      DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                              + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+designName+"'" ,
                      null
              );
          break;
          }
      }

   }

   public static void getDesignName(SQLiteDatabase db){
       Cursor c=db.query(DesignsTableColumns.DESIGN_TABLE_NAME,new String[]{DesignsTableColumns.COLUMN_DESIGN},
               null,null,null,null,null

       );

       ArrayList<String> array=new ArrayList<>();
        int index=c.getColumnIndex(DesignsTableColumns.COLUMN_DESIGN);
       while(c.moveToNext())
       {
           array.add(c.getString(index));
           Log.d(TAG, "DesignNameDesignTable "+array.get(index));
       }

    }

    public static void updateTotQuantities(SQLiteDatabase db,int id,String design,int quan)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DesignsTableColumns.COLUMN_TOTALQUANTITY,quan);

        db.update(DesignsTableColumns.DESIGN_TABLE_NAME,
                 contentValues,
                DesignsTableColumns.DESIGN_COLUMN_id+" = "+"'"+id+ "'"   + " AND "
                        + DesignsTableColumns.COLUMN_DESIGN+ " = "+"'"+design+"'",
                 null
        );

    }

}
