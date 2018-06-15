package com.mytrendin.googlemapsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nimra Maqsood Ahmed on 29/04/2018.
 */

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RecyclerViewHolders> {
    private Context context;
    private ArrayList<RestaurantsModal> modelList;
    private OnItemClickListener mItemClickListener;
    public RestaurantsAdapter(Context context, ArrayList<RestaurantsModal> modelList)
    {
        this.context = context;
        this.modelList = modelList;

    }

    @Override public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list, null);
    RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
    return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position)
    {
        RestaurantsModal restaurants = modelList.get(position);
       // holder.iv_Logo.setImageResource (restaurants.logo);
        Picasso.with(context).load(restaurants.logo).into(holder.iv_Logo);
        holder.tvName.setText((CharSequence) restaurants.name);
        holder.tvAddress.setText((CharSequence) restaurants.address);
    }

    @Override
    public int getItemCount()
    {
        return modelList.size();
    }

    public void addItems(ArrayList<RestaurantsModal> activitiesList)
    {
        modelList.addAll(activitiesList);
    this.notifyDataSetChanged();
    } //

    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ImageView iv_Logo;
        public TextView tvName, tvAddress;
        public RecyclerViewHolders(View itemView)
        {
            super(itemView);
            iv_Logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            iv_Logo.setOnClickListener(this);
        }

        @Override public void onClick(View v)
        {
            if (mItemClickListener != null)
            {
                mItemClickListener.onItemClick(v, getAdapterPosition(), modelList);
            }
        }


    }

    public interface OnItemClickListener
    {
        public void onItemClick(View v, int position, ArrayList<RestaurantsModal> modelList);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener)
    {
        this.mItemClickListener = mItemClickListener;
    }

    public RestaurantsModal getItem (int position)
    {
        return  modelList.get(position);
    }
}
