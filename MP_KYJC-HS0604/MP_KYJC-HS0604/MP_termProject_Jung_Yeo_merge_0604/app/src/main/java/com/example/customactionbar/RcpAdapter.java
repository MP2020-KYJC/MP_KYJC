package com.example.customactionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RcpAdapter extends RecyclerView.Adapter<RcpAdapter.ViewHolder> {

    private ArrayList<Rcp_item_list> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public RcpAdapter(Context context, ArrayList<Rcp_item_list> itemList, View.OnClickListener onClickItem){
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.rcp_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Rcp_item_list item = itemList.get(position);

        holder.textView.setText(item.getTitle());
        holder.textView.setTag(item);
        holder.imageView.setImageResource(item.getIcon());
        holder.textView.setOnClickListener(onClickItem);
    }

    @Override
    public int getItemCount(){
        return  itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.rcp_RecyclerView_TextView);
            imageView = itemView.findViewById(R.id.rcp_RecyclerView_ImageView);
        }
    }
}


















