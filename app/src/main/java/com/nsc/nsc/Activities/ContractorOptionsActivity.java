package com.nsc.nsc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.nsc.nsc.R;

public class ContractorOptionsActivity extends AppCompatActivity {

    CardView cvAddtostock,cvAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_options);



        cvAddtostock= (CardView) findViewById(R.id.cvAddtostock);
        cvAccount= (CardView) findViewById(R.id.cvAccount);
                 final String name=getIntent().getStringExtra("ContName");

        setTitle(name.toUpperCase());
        cvAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorOptionsActivity.this,ContractorCarDisplay.class);
                i.putExtra("ContName",name);
                startActivity(i);
            }
        });

        cvAddtostock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ContractorOptionsActivity.this,AddToStockCarDisplay.class);
                i.putExtra("ContName",name);
                startActivity(i);
            }
        });
    }
}
