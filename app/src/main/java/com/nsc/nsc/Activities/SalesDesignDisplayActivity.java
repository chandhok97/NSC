package com.nsc.nsc.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.SalesAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

public class SalesDesignDisplayActivity extends AppCompatActivity {
    RecyclerView rvdesignname;
    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListTotQuantities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_design_display);
        setTitle("SALES");
        int id=getIntent().getIntExtra("id",-1);
        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();
        db=myNscDatabaseHelper.getWritableDatabase();
        arrayListDesignName= DesignNamesOnlyTable.getDesignNames(db);
        arrayListTotQuantities= DesignsTable.getTotalQuanties(db,id);

        rvdesignname= (RecyclerView) findViewById(R.id.rvSalesDesignName);
        rvdesignname.setLayoutManager(new LinearLayoutManager(this));
        SalesAdapter salesAdapter=new SalesAdapter(this,arrayListDesignName,arrayListTotQuantities,id,db);
        rvdesignname.setAdapter(salesAdapter);

    }
}
