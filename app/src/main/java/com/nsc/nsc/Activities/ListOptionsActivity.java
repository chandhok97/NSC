package com.nsc.nsc.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.nsc.nsc.R;
import com.squareup.picasso.Picasso;

public class ListOptionsActivity extends AppCompatActivity {

    ImageView ivCont,ivStock,ivSales;
    CardView cvCont,cvStock,cvSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_options);

        ivCont= (ImageView) findViewById(R.id.ivCont);
        ivStock= (ImageView) findViewById(R.id.ivStock);
        ivSales= (ImageView) findViewById(R.id.ivSale);

        cvCont= (CardView) findViewById(R.id.cvContractor);
        cvStock= (CardView) findViewById(R.id.cvStock);
        cvSales= (CardView) findViewById(R.id.cvSales);


        Picasso.with(this).load("http://renovationcircle.com/images/contractors.png").resize(300,300).into(ivCont);
        Picasso.with(this).load("http://www.pngmart.com/files/3/Stock-Market-PNG-HD.png").resize(300,300).into(ivStock);
        Picasso.with(this).load("https://irp-cdn.multiscreensite.com/2b5d29c7/dms3rep/multi/mobile/hrl_commercial-removals_row1-430x210.png").resize(300,300).into(ivSales);

        cvCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ListOptionsActivity.this,ContractorsListActivity.class);
                startActivity(i);
            }
        });


        cvStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ListOptionsActivity.this,StockActivity.class);
                startActivity(i);
            }
        });

        cvSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ListOptionsActivity.this,SalesCarDisplayActivity.class);
                startActivity(i);
            }
        });
    }
}
