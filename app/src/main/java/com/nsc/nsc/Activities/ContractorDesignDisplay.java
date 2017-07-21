package com.nsc.nsc.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.DesignsDisplayAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

public class ContractorDesignDisplay extends AppCompatActivity {
    public static final String TAG="CAR NAME";

    RecyclerView rvdesignname;
    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListContQuanties;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_design_display);
         String name=getIntent().getStringExtra("ContName");
        setTitle(name.toUpperCase());
        Integer id=getIntent().getIntExtra("id",-1);
       myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();

        arrayListDesignName= DesignNamesOnlyTable.getDesignNames(db);

        arrayListContQuanties= DesignsTable.getContQuantities(db,id,name);
        rvdesignname= (RecyclerView) findViewById(R.id.rvContDesignName);

        rvdesignname.setLayoutManager(new LinearLayoutManager(this));
        DesignsDisplayAdapter designsDisplayAdapter=new DesignsDisplayAdapter(this,arrayListDesignName,arrayListContQuanties);
        rvdesignname.setAdapter(designsDisplayAdapter);

    }
}
