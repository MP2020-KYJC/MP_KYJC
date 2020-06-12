package com.example.fragment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rcpAdapter extends RecyclerView.Adapter<rcpAdapter.ViewHolder> {

    private ArrayList<item_list> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public rcpAdapter(Context context, ArrayList<item_list> itemList, View.OnClickListener onClickItem){
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        item_list item = itemList.get(position);

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

            textView = itemView.findViewById(R.id.item_textview);
            imageView = itemView.findViewById(R.id.imageView1);
        }
    }
}


















