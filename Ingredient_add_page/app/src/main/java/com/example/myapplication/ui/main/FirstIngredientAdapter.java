package com.example.myapplication.ui.main;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class FirstIngredientAdapter extends RecyclerView.Adapter<FirstIngredientAdapter.ViewHolder> {

    private String[] itemList;
    private int position;
    private Context context;
    private View.OnClickListener onClickItem;

    public FirstIngredientAdapter(Context context, String[] itemList, int position){
        this.context = context;
        this.position = position;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.first_ingredient, parent, false);

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
                        itemList.add(new item_list(R.drawable.color1,"첫번째"));
                        itemList.add(new item_list(R.drawable.color1,"두번째"));
                        itemList.add(new item_list(R.drawable.color1,"세번째"));
                        itemList.add(new item_list(R.drawable.color1,"네번째"));
                        itemList.add(new item_list(R.drawable.color1,"다섯번째"));
                        itemList.add(new item_list(R.drawable.color1,"여섯번째"));
                        itemList.add(new item_list(R.drawable.color1,"일곱번째"));
                        itemList.add(new item_list(R.drawable.color1,"여덟번째"));
                        itemList.add(new item_list(R.drawable.color1,"아홉번째"));
                        itemList.add(new item_list(R.drawable.color1,"열번째"));
                        itemList.add(new item_list(R.drawable.color1,"열한번째"));
                        break;
                    case 1:
                        itemList.add(new item_list(R.drawable.color2,"첫번째"));
                        break;
                    case 2:
                        itemList.add(new item_list(R.drawable.color3,"첫번째"));
                        break;
                    case 3:
                        itemList.add(new item_list(R.drawable.color1,"첫번째"));
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

        secondIngredientAdapter = new SecondIngredientAdapter(this.context, itemList, onClickItem);
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


















