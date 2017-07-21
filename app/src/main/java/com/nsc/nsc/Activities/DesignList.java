package com.nsc.nsc.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.DesignsDisplayAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

public class DesignList extends AppCompatActivity {

     RecyclerView rvdesignname;
     SQLiteDatabase db=null;
     MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListTotalQuanties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_list);
        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();

        arrayListDesignName= DesignNamesOnlyTable.getDesignNames(db);
        int id=getIntent().getIntExtra("id",-1);

        arrayListTotalQuanties= DesignsTable.getTotalQuanties(db,id);

        rvdesignname= (RecyclerView) findViewById(R.id.rvDesignName);

        rvdesignname.setLayoutManager(new  LinearLayoutManager(this));
        DesignsDisplayAdapter designsDisplayAdapter=new DesignsDisplayAdapter(this,arrayListDesignName,arrayListTotalQuanties);
        rvdesignname.setAdapter(designsDisplayAdapter);

    }
}
