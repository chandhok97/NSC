package com.nsc.nsc.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsc.nsc.R;

import java.util.ArrayList;

/**
 * Created by rippy3402 on 19-07-2017.
 */

public class CarsDisplayAdapter extends RecyclerView.Adapter<CarsDisplayAdapter.CarsViewHolder> {
    private Context context;
    private ArrayList<String> arrayListCarNames;

    public static final String TAG="Position id";


    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener
    {
        void onclick(Integer position  );
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    public CarsDisplayAdapter(Context context, ArrayList<String> arrayListCarNames) {
        this.context = context;
        this.arrayListCarNames = arrayListCarNames;


    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.cars_list,parent,false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarsViewHolder holder, final int position) {
      final String carName=arrayListCarNames.get(position);
      holder.tvcarname.setText(carName);
      holder.view.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
           if(onItemClickListener != null)
           {
                onItemClickListener.onclick(position);
           }
          }
      });

        Log.d(TAG, "Positon id "+position);

    }

    @Override
    public int getItemCount() {
        return arrayListCarNames.size();
    }



    static class CarsViewHolder extends RecyclerView.ViewHolder{
        TextView tvcarname;
        View view;
        public CarsViewHolder(View itemView) {
            super(itemView);
            tvcarname= (TextView) itemView.findViewById(R.id.tvcarname);
            view=itemView;
        }
    }
}
