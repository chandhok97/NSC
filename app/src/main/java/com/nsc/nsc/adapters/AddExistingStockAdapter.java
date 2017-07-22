package com.nsc.nsc.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nsc.nsc.R;
import com.nsc.nsc.nscdatabase.tables.DesignsTable;

import java.util.ArrayList;

/**
 * Created by rippy3402 on 22-07-2017.
 */

public class AddExistingStockAdapter extends RecyclerView.Adapter<AddExistingStockAdapter.ExistingViewHolder> {
    Context context;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListTotQuantities;
    int id;
    SQLiteDatabase db;

    public AddExistingStockAdapter(Context context, ArrayList<String> arrayListDesignName, ArrayList<Integer> arrayListTotQuantities, int id, SQLiteDatabase db) {
        this.context = context;
        this.arrayListDesignName = arrayListDesignName;
        this.arrayListTotQuantities = arrayListTotQuantities;
        this.id = id;
        this.db = db;
    }

    @Override
    public ExistingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.add_existing_layout,parent,false);
        return new ExistingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExistingViewHolder holder,final int position) {
        final String design=arrayListDesignName.get(position);
        holder.tvExistingDesign.setText(design);

        holder.ivExistingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int quantity=Integer.valueOf(holder.etExistingAdd.getText().toString());
                String d=arrayListDesignName.get(position);

                int initQuan=arrayListTotQuantities.get(position);
                DesignsTable.updateTotQuantities(db,id,d,initQuan+quantity);
                holder.etExistingAdd.setText("");
                Toast.makeText(context, "Sets Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListDesignName.size();
    }

    static class ExistingViewHolder extends RecyclerView.ViewHolder{
        TextView tvExistingDesign;
        EditText etExistingAdd;
        ImageButton ivExistingButton;

        public ExistingViewHolder(View itemView) {
            super(itemView);

            tvExistingDesign= (TextView) itemView.findViewById(R.id.tvexistingdesing);
            etExistingAdd= (EditText) itemView.findViewById(R.id.etExistingAdd);
            ivExistingButton= (ImageButton) itemView.findViewById(R.id.ivExistingAdd);


        }
    }
}
