package com.mytrendin.googlemapsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ATTech_Android_1 on 01/05/2018.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<TableModal> modelList;


    public TableAdapter(Context context, ArrayList<TableModal> modelList) {
        this.context = context;
        this.modelList = modelList;

    }

    @Override
    public TableAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list, null);
        TableAdapter.RecyclerViewHolder rcv = new TableAdapter.RecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(TableAdapter.RecyclerViewHolder holder, int position) {
        TableModal table = modelList.get(position);
        //holder.iv_tablefor2.setImageResource (restaurants.logo);
        //Picasso.with(context).load(table.logo).into(holder.iv_tablefor2);
        holder.tv_tableId.setText((CharSequence) table.tableId);
        holder.tv_status.setText((CharSequence) table.status);
        if(table.status.equals("Reserved"))
        {
            holder.iv_tablefor2.setImageResource (R.drawable.ic_table_reserved);
        }
        else if(table.status.equals("Booked"))
        {
            holder.iv_tablefor2.setImageResource (R.drawable.ic_table_occupied);
        }
        else
        {
            holder.iv_tablefor2.setImageResource (R.drawable.ic_table_empty);
        }

    }

    @Override
    public int getItemCount()
    {
        return modelList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView iv_tablefor2;
        public TextView tv_tableId, tv_status;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            iv_tablefor2 = (ImageView) itemView.findViewById(R.id.iv_tablefor2);
            tv_tableId = (TextView) itemView.findViewById(R.id.tv_tableId);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);

        }



        }

    public TableModal getItem (int position)
    {
        return  modelList.get(position);
    }
}





