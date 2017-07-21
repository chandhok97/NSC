package com.nsc.nsc.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nsc.nsc.R;
import com.nsc.nsc.adapters.CarsDisplayAdapter;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.CarsTable;

import java.util.ArrayList;

public class CurrentStock extends AppCompatActivity {

    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListCarNames=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_stock);
         myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();

        arrayListCarNames= CarsTable.getCarNames(db);
        recyclerView= (RecyclerView) findViewById(R.id.rvCarName);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CarsDisplayAdapter carsDisplayAdapter=new CarsDisplayAdapter(this,arrayListCarNames);
        recyclerView.setAdapter(carsDisplayAdapter);

        carsDisplayAdapter.setOnItemClickListener(new CarsDisplayAdapter.OnItemClickListener() {
            @Override
            public void onclick(Integer position) {
                Intent i=new Intent(CurrentStock.this,DesignList.class);
                i.putExtra("id",position+1);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        db.close();
    }
}
