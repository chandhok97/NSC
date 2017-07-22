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
 * Created by rippy3402 on 21-07-2017.
 */

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesViewHolder> {
    Context context;
    ArrayList<String> arrayListDesignName;
    ArrayList<Integer> arrayListTotQuantities;
    int id;
    SQLiteDatabase db;

    public SalesAdapter(Context context, ArrayList<String> arrayListDesignName, ArrayList<Integer> arrayListTotQuantities, int id,SQLiteDatabase db) {
        this.context = context;
        this.arrayListDesignName = arrayListDesignName;
        this.arrayListTotQuantities = arrayListTotQuantities;
        this.id = id;
        this.db=db;
    }

    @Override
    public SalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.sales_update_stock_list,parent,false);
        return new SalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SalesViewHolder holder, final int position) {
        final String design=arrayListDesignName.get(position);
        holder.tvSalesview.setText(design);

        holder.ivSubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int quantity=Integer.valueOf(holder.etSubt.getText().toString());
                String d=arrayListDesignName.get(position);

                int initQuan=arrayListTotQuantities.get(position);
                DesignsTable.updateTotQuantities(db,id,d,initQuan-quantity);
                holder.etSubt.setText("");
                Toast.makeText(context, "Sets Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListDesignName.size();
    }

    static class SalesViewHolder extends RecyclerView.ViewHolder{

        TextView tvSalesview;
        EditText etSubt;
        ImageButton ivSubt;

        public SalesViewHolder(View itemView) {
            super(itemView);

            tvSalesview= (TextView) itemView.findViewById(R.id.tvSalesDesign);
            etSubt= (EditText) itemView.findViewById(R.id.etSubt);
            ivSubt= (ImageButton) itemView.findViewById(R.id.ivSubt);
        }
    }
}