package com.nsc.nsc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.nsc.nsc.R;

public class ContractorsListActivity extends AppCompatActivity {

    CardView cvAnil,cvDharampal,cvMohammad,cvPinto,cvVinod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractors_list);

        cvAnil= (CardView) findViewById(R.id.cvAnil);
        cvDharampal= (CardView) findViewById(R.id.cvDharampal);
        cvMohammad= (CardView) findViewById(R.id.cvMohammad);
        cvPinto= (CardView) findViewById(R.id.cvPinto);
        cvVinod= (CardView) findViewById(R.id.cvVinod);

        cvAnil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorsListActivity.this,ContractorOptionsActivity.class);
                i.putExtra("ContName","Anil");
                startActivity(i);
            }
        });

        cvDharampal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorsListActivity.this,ContractorOptionsActivity.class);
                i.putExtra("ContName","Dharampal");
                startActivity(i);
            }
        });

        cvMohammad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(ContractorsListActivity.this,ContractorOptionsActivity.class);
               i.putExtra("ContName","Mohammad");
               startActivity(i);
            }
        });

        cvPinto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorsListActivity.this,ContractorOptionsActivity.class);
                i.putExtra("ContName","Pinto");
                startActivity(i);
            }
        });

        cvVinod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorsListActivity.this,ContractorOptionsActivity.class);
                i.putExtra("ContName","Vinod");
                startActivity(i);
            }
        });
    }
}
