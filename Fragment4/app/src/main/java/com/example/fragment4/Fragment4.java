package com.example.fragment4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class Fragment4 extends Fragment {
    private RecyclerView listview1;
    private RecyclerView listview2;
    IngredientAdapter adapter1;
    private rcpAdapter adapter2;
    private Context mContext;
//    Button ingredient_add, rfg_management;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

//        ingredient_add = (Button)view.findViewById(R.id.rfg_button_ingredient_add);
//        rfg_management = (Button)view.findViewById(R.id.rfg_button_rfg_management);

        ImageButton next = view.findViewById(R.id.rfg_Button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.onRfgFragmentChanged();
            }
        });

        ingredient_list(view);
        edit_list(view);


        return view;
    }
    private void ingredient_list(View view){
        listview2 = view.findViewById(R.id.rfg_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview2.setLayoutManager(layoutManager);
        ArrayList<item_list> itemList = new ArrayList<item_list>();
        itemList.add(new item_list(R.drawable.color1,"양파"));
        itemList.add(new item_list(R.drawable.color2,"상추"));
        itemList.add(new item_list(R.drawable.color3,"배추"));
        adapter1 = new IngredientAdapter(mContext, itemList, onClickItem);
        listview2.setAdapter(adapter1);
    }
    private void edit_list(View view){
        listview1 = view.findViewById(R.id.rgh_RecyclerView_rcp_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        listview1.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<item_list> itemList = new ArrayList<item_list>();
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color2,"스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color2, "스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color2,"스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color3,"김치찌개"));
        itemList.add(new item_list(R.drawable.color3, "김치찌개"));
        itemList.add(new item_list(R.drawable.color3,"김치찌개"));
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color1,"토스트"));
        itemList.add(new item_list(R.drawable.color2,"스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color2, "스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color2,"스팸마요덮밥"));
        itemList.add(new item_list(R.drawable.color3,"김치찌개"));
        itemList.add(new item_list(R.drawable.color3, "김치찌개"));
        itemList.add(new item_list(R.drawable.color3,"김치찌개"));
//        여기까지

        adapter2 = new rcpAdapter(mContext, itemList, onClickItem);
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
}