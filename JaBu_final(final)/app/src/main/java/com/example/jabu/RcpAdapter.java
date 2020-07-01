package com.example.jabu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RcpAdapter extends RecyclerView.Adapter<RcpAdapter.ViewHolder> {
    public ArrayList<String> scrap_list = new ArrayList<String>();
    private ArrayList<item_list> itemList;
    private Context context;

    public RcpAdapter(Context context, ArrayList<item_list> itemList){
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.rcp_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        item_list item = itemList.get(position);


        holder.textView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount(){
        return  itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.rcp_RecyclerView_TextView);
            imageView = itemView.findViewById(R.id.rcp_RecyclerView_ImageView);
            linearLayout = itemView.findViewById(R.id.rcp_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), recipe_detail_page.class);
                    intent.putExtra("ctId", itemList.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(intent);
                }
            });

        }
    }
}


















