package com.example.jabu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {
    private ArrayList<Tip_list> itemList;
    private Context context;

    public TipAdapter(Context context, ArrayList<Tip_list> itemList){
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.tip_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Tip_list item = itemList.get(position);

        holder.textView.setText(item.getTitle());
    }

    @Override
    public int getItemCount(){
        return  itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.tip_RecyclerView_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), tip_detail_page.class);
                    intent.putExtra("tipId", itemList.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}


















