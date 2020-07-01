package com.example.jabu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_ingredient_list;

//SecondIngredientAdapter랑 같음
public class IngredientAdapter_1 extends RecyclerView.Adapter<IngredientAdapter_1.ViewHolder> {

    private ArrayList<item_list> itemList;
    private Context context;

    public IngredientAdapter_1(Context context, ArrayList<item_list> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ingredient, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        item_list item = itemList.get(position);

        holder.textView.setText(item.getTitle());
        holder.textView.setTag(item);
        holder.imageView.setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.item_textview);
            imageView = itemView.findViewById(R.id.imageView1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), Ingredient_DialogActivity.class);
                    //DB에서 가져온 재료이름/재료이미지 위치/냉장고에 추가한 날짜/유통기한 정보를 보냄
                    intent.putExtra("id", itemList.get(getAdapterPosition()).getId());
                    ((Activity) context).startActivityForResult(intent, 1);
                    notifyItemRemoved(getAdapterPosition());


                }
            });
            //길게 클릭시 실행되는 창
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("재료 삭제");
                    builder.setMessage("[" + itemList.get(getAdapterPosition()).getTitle() + "]을(를) 삭제하시겠습니까?");
                    builder.setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        for (int i = 0; i < all_ingredient_list.size(); i++) {
                                            if (all_ingredient_list.get(i).igID.equals(itemList.get(getAdapterPosition()).getId())) {
                                                Ingredients ig = new Ingredients();
                                                ig = all_ingredient_list.get(i);
                                                ig.setIsIsAdded("0");
                                                all_ingredient_list.set(i, ig);
                                            }
                                        }
                                        itemList.remove(getAdapterPosition());
                                        notifyItemRemoved(getAdapterPosition());
                                    } catch (IndexOutOfBoundsException e) {
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
                    return true;
                }
            });

        }
    }
}


















