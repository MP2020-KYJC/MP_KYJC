package com.example.jabu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_ingredient_list;

public class FirstIngredientAdapter extends RecyclerView.Adapter<FirstIngredientAdapter.ViewHolder> {

    private String[] itemList;
    private int position;
    private Context context;

    public FirstIngredientAdapter(Context context, String[] itemList, int position){
        this.context = context;
        this.position = position;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.first_ingredient_add, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String item = itemList[position];
        ArrayList<item_list> itemList = new ArrayList <item_list>();
        SecondIngredientAdapter secondIngredientAdapter;
        holder.textView.setText(item);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.context, 5);
        holder.recyclerView.setLayoutManager(layoutManager);

        switch (this.position){
            case 0:
                switch (position){
                    case 0:
//                        TODO
                        for(int i =0;i<all_ingredient_list.size();i++){
                            if(all_ingredient_list.get(i).igIsAdded.equals("0")){
                                String Image = all_ingredient_list.get(i).igImage;
                                int icon = context.getResources().getIdentifier(Image, "drawable", context.getPackageName());
//
                                itemList.add(new item_list(icon, all_ingredient_list.get(i).igName, all_ingredient_list.get(i).igID));

                            }
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                break;
            case 1:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                break;
            case 2:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                break;
            case 3:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                break;
            case 4:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case 5:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 6:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
                break;
            case 7:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
                break;
        }

        secondIngredientAdapter = new SecondIngredientAdapter(this.context, itemList);
        holder.recyclerView.setAdapter(secondIngredientAdapter);
    }

    @Override
    public int getItemCount(){
        int count = itemList.length;
        return  count;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RecyclerView recyclerView;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.ingredient_firstRecyclerView_textView);
            recyclerView = itemView.findViewById(R.id.ingredient_secondRecyclerView);
        }
    }
}


















