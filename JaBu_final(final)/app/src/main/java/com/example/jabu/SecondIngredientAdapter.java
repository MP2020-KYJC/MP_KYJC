package com.example.jabu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_ingredient_list;

public class SecondIngredientAdapter extends RecyclerView.Adapter<SecondIngredientAdapter.ViewHolder> {

    private ArrayList<item_list> itemList;
    private Context context;

    public SecondIngredientAdapter(Context context, ArrayList<item_list> itemList){
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.second_ingredient_add, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        item_list item = itemList.get(position);

        holder.textView.setText(item.getTitle());
        holder.textView.setTag(item);
        holder.imageView.setImageResource(item.getIcon());

    }

    @Override
    public int getItemCount(){
        return  itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(final View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.item_textview);
            imageView = itemView.findViewById(R.id.imageView1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                    builder.setTitle("재료 추가");
                    builder.setMessage(itemList.get(getAdapterPosition()).getTitle()+"을(를) 추가하시겠습니까?");
                    builder.setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    try{
                                        for(int i =0;i<all_ingredient_list.size();i++){
                                            if(all_ingredient_list.get(i).igID.equals(itemList.get(getAdapterPosition()).getId())){
                                                Ingredients ig = new Ingredients();
                                                ig = all_ingredient_list.get(i);
                                                ig.setIsIsAdded("1");
                                                all_ingredient_list.set(i, ig);
                                            }
                                        }
//                                        Toast.makeText(view., itemList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                                        itemList.remove(getAdapterPosition());
                                        notifyItemRemoved(getAdapterPosition());
                                    }catch(IndexOutOfBoundsException e){
                                        e.printStackTrace();
                                    }
                                }
                            });
                    builder.setNegativeButton("아니오",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    builder.show();
                }
            });
        }
    }
}


















