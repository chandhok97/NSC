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

public class AddStockAdapter extends RecyclerView.Adapter<AddStockAdapter.AddStockViewHolder> {
    Context context;
     int id;
     String name;
    ArrayList<String> arrayListDesignName;
    SQLiteDatabase db;
    ArrayList<Integer> arrayList;
    ArrayList<Integer> arrayListCont;
    public AddStockAdapter(Context context, Integer id, String name,ArrayList<String> arrayListDesignName,SQLiteDatabase db
            ,ArrayList<Integer> arrayList,ArrayList<Integer> arrayListCont){
        this.context = context;
        this.id = id;
        this.arrayListDesignName=arrayListDesignName;
        this.name = name;
        this.db=db;
        this.arrayList=arrayList;
    this.arrayListCont=arrayListCont;
    }

    @Override
    public AddStockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.update_stock_list,parent,false);
        return new AddStockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AddStockViewHolder holder, final int position) {
        final String designName=arrayListDesignName.get(position);
        holder.tvDesign.setText(designName);


        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int quantity=Integer.valueOf(holder.etAdd.getText().toString());
                 String d=arrayListDesignName.get(position);
                int totinitQuan=arrayList.get(position);
                int continit=arrayListCont.get(position);
                DesignsTable.updateQuantities(db,id,name,quantity,d,totinitQuan,continit);
                holder.etAdd.setText("");
                Toast.makeText(context, "Sets Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListDesignName.size();
    }

    static class AddStockViewHolder extends RecyclerView.ViewHolder{
        TextView tvDesign;
        EditText etAdd;
        ImageButton ivAdd;

        public AddStockViewHolder(View itemView) {
            super(itemView);
            tvDesign= (TextView) itemView.findViewById(R.id.tvdesign);
            etAdd= (EditText) itemView.findViewById(R.id.etAdd);
            ivAdd= (ImageButton) itemView.findViewById(R.id.ivAdd);
        }
    }
}
