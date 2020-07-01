package com.example.jabu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_contents_list;
import static com.example.jabu.LoadingDBSection.all_ingredient_list;
import static com.example.jabu.LoadingDBSection.all_hashtags_list;


public class Rfg_Page extends Fragment {
    private RecyclerView listview1;
    private RecyclerView listview2;
    IngredientAdapter adapter1;
    private RcpAdapter adapter2;
    private Context mContext;
    public ArrayList<String> absjd = new ArrayList<String>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rfg_page, container, false);

        ImageButton next = view.findViewById(R.id.rfg_Button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Ingredient_Page.class);
                startActivityForResult(intent, 0);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ingredient_list(view);
        edit_list(view);
    }

    private void ingredient_list(View view){
        listview2 = view.findViewById(R.id.rfg_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview2.setLayoutManager(layoutManager);
        ArrayList<item_list> itemList = new ArrayList<item_list>();

        //TODO: 구현한 부분
        for (int i = 0; i < all_ingredient_list.size(); i++) {
            if (all_ingredient_list.get(i).igIsAdded.equals("1")) {
                int icon = getResources().getIdentifier(all_ingredient_list.get(i).igImage, "drawable", mContext.getPackageName());
                itemList.add(new item_list(icon, all_ingredient_list.get(i).igName, all_ingredient_list.get(i).igID));
            }
        }



        adapter1 = new IngredientAdapter(mContext, itemList, onClickItem);
        listview2.setAdapter(adapter1);
    }
    private void edit_list(View view){
        listview1 = view.findViewById(R.id.rgh_RecyclerView_rcp_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        listview1.setLayoutManager(layoutManager);
        ArrayList<item_list> itemList = new ArrayList<item_list>();
        //TODO: 추가한 부분
        int[] index = getRecipeListToLoad();
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
                itemList.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter2 = new RcpAdapter(mContext, itemList);
        listview1.setAdapter(adapter2);
    }
    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public int[] getRecipeListToLoad() {
        int[] index = new int[all_contents_list.size()];
        ArrayList<String> ingredientList = new ArrayList<>();

        for (int i = 0; i < all_ingredient_list.size(); i++) {
            if (all_ingredient_list.get(i).igIsAdded.equals("1")) {
                ingredientList.add(all_ingredient_list.get(i).igName);
            }
        }

        for (int i = 0; i < all_contents_list.size(); i++) {
            for (int j = 0; j < ingredientList.size(); j++) {
                if (all_contents_list.get(i).ctIg.contains(ingredientList.get(j))) {
                    index[i] += 1;
                }
            }
        }

        return index;
    }

}