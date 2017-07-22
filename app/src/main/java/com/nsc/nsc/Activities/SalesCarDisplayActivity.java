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

public class SalesCarDisplayActivity extends AppCompatActivity {

    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;
    ArrayList<String> arrayListCarNames=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_car_display);

        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getReadableDatabase();
        setTitle("SALES");
        arrayListCarNames= CarsTable.getCarNames(db);
        recyclerView= (RecyclerView) findViewById(R.id.rvSalesCarName);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CarsDisplayAdapter carsDisplayAdapter=new CarsDisplayAdapter(this,arrayListCarNames);
        recyclerView.setAdapter(carsDisplayAdapter);

        carsDisplayAdapter.setOnItemClickListener(new CarsDisplayAdapter.OnItemClickListener() {
            @Override
            public void onclick(Integer position) {
              Intent intent=new Intent(SalesCarDisplayActivity.this,SalesDesignDisplayActivity.class);
                intent.putExtra("id",position+1);
                startActivity(intent);
            }
        });

    }
}
