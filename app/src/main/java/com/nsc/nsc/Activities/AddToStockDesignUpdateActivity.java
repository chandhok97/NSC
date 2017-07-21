package com.nsc.nsc.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.AddStockAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

public class AddToStockDesignUpdateActivity extends AppCompatActivity {

    RecyclerView rvdesignname;
    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListDesignName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_stock_design_update);

        String name=getIntent().getStringExtra("ContName");
        setTitle(name.toUpperCase());
        Integer id=getIntent().getIntExtra("id",-1);
        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();
        db=myNscDatabaseHelper.getWritableDatabase();

        ArrayList<Integer> arrayList= DesignsTable.getContQuantities(db,id,name);


        arrayListDesignName= DesignNamesOnlyTable.getDesignNames(db);
        rvdesignname= (RecyclerView) findViewById(R.id.rvAddToStockDesignName);
        rvdesignname.setLayoutManager(new LinearLayoutManager(this));
        AddStockAdapter addStockAdapter=new AddStockAdapter(this,id,name,arrayListDesignName,db,arrayList);
        rvdesignname.setAdapter(addStockAdapter);


    }
}
