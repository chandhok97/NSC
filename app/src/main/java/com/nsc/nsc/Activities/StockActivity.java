package com.nsc.nsc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.nsc.nsc.R;

public class StockActivity extends AppCompatActivity {

    CardView cvCurr,cvAddNewItem,cvAddExisting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        cvAddNewItem= (CardView) findViewById(R.id.cvAddNewItem);
        cvCurr= (CardView) findViewById(R.id.cvCurrent);
        cvAddExisting= (CardView) findViewById(R.id.cvAddExistingStock);
        cvAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add=new Intent(StockActivity.this,AddNewItemToDBActivity.class);
                startActivity(add);
            }
        });

        cvCurr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StockActivity.this,CurrentStock.class);
                startActivity(i);
            }
        });

        cvAddExisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i=new Intent(StockActivity.this,AddExistingStock.class);
                startActivity(i);
            }
        });


    }
}
