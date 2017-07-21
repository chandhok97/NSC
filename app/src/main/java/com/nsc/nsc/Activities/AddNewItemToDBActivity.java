package com.nsc.nsc.Activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nsc.nsc.R;
import com.nsc.nsc.nscdatabase.MyNscDatabaseHelper;
import com.nsc.nsc.nscdatabase.tables.CarsTable;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;
import com.nsc.nsc.nscdatabase.tables.DesignNamesOnlyTable;

import java.util.ArrayList;

public class AddNewItemToDBActivity extends AppCompatActivity {

    EditText addNewCar,addNewDesign;
    Button btnAddCar,btnAddDesign;
    SQLiteDatabase db=null;
    MyNscDatabaseHelper myNscDatabaseHelper;


    public static final String TAG="MY TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item_to_db);

        myNscDatabaseHelper=new MyNscDatabaseHelper(this);
        db=myNscDatabaseHelper.getWritableDatabase();

        addNewCar= (EditText) findViewById(R.id.newCarName);
        addNewDesign= (EditText) findViewById(R.id.newDesign);
        btnAddCar= (Button) findViewById(R.id.addnewCar);
        btnAddDesign= (Button) findViewById(R.id.addnewdesign);




        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CarsTable.addCarName(db,addNewCar.getText().toString());

           DesignsTable.addToExistingDesigns(db);
                addNewCar.setText("");
                Toast.makeText(AddNewItemToDBActivity.this, "New Car Added", Toast.LENGTH_SHORT).show();
            }
        });

       btnAddDesign.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               DesignsTable.addToDesignTableNewDesign(db,addNewDesign.getText().toString());

               DesignNamesOnlyTable.addDesignOnly(db,addNewDesign.getText().toString());
               addNewDesign.setText("");
               Toast.makeText(AddNewItemToDBActivity.this, "New Design Added", Toast.LENGTH_SHORT).show();
               DesignsTable.getDesignName(db);
           }
       });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        db.close();
    }
}

