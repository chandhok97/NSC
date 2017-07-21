package com.nsc.nsc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.nsc.nsc.R;

import java.util.ArrayList;

/**
 * Created by rippy3402 on 20-07-2017.
 */

public class DesignsDisplayAdapter extends RecyclerView.Adapter<DesignsDisplayAdapter.DesignViewHolder> {

    public static final String TAG="QUANTITY";
    private Context context;
    private ArrayList<String> arrayListDesignName;
    private ArrayList<Integer> arrayListTotalQuantity;

    public DesignsDisplayAdapter(Context context, ArrayList<String> arrayListDesignName, ArrayList<Integer> arrayListTotalQuantity) {
        this.context = context;
        this.arrayListDesignName = arrayListDesignName;
        this.arrayListTotalQuantity = arrayListTotalQuantity;
    }

    @Override
    public DesignViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.designs_list,parent,false);
        return new DesignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DesignViewHolder holder, int position) {
     final String designName=arrayListDesignName.get(position);
     final Integer totalQuantity=arrayListTotalQuantity.get(position);
        Log.d(TAG, "Quantity " + totalQuantity);
       holder.tvdesignname.setText(designName);
        holder.tvquantity.setText(String.valueOf(totalQuantity));
    }

    @Override
    public int getItemCount() {
        return arrayListDesignName.size();
    }

    static class DesignViewHolder extends RecyclerView.ViewHolder{
       TextView tvdesignname;
       TextView tvquantity;

       public DesignViewHolder(View itemView) {
           super(itemView);
           tvdesignname= (TextView) itemView.findViewById(R.id.tvdesign);
           tvquantity= (TextView) itemView.findViewById(R.id.tvquantity);

       }
   }

}
