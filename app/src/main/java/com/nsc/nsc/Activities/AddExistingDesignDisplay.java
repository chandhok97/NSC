package com.nsc.nsc.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.AddExistingStockAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

public class AddExistingDesignDisplay extends AppCompatActivity {

    RecyclerView rvdesignname;
    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListTotQuantities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_existing_design_display);

        int id=getIntent().getIntExtra("id",-1);
        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();
        db=myNscDatabaseHelper.getWritableDatabase();
        arrayListDesignName= DesignNamesOnlyTable.getDesignNames(db);
        arrayListTotQuantities= DesignsTable.getTotalQuanties(db,id);
        rvdesignname= (RecyclerView) findViewById(R.id.rvAddExistingDesign);
        rvdesignname.setLayoutManager(new LinearLayoutManager(this));
        AddExistingStockAdapter addExistingStockAdapter=new AddExistingStockAdapter(this,arrayListDesignName,arrayListTotQuantities,id,db);
        rvdesignname.setAdapter(addExistingStockAdapter);
    }
}
