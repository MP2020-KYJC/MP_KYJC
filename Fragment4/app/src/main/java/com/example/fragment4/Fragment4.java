package com.example.fragment4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private RecyclerView listview;
    private rcpAdapter adapter;
    private Context mContext;
//    Button ingredient_add, rfg_management;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

//        ingredient_add = (Button)view.findViewById(R.id.rfg_button_ingredient_add);
//        rfg_management = (Button)view.findViewById(R.id.rfg_button_rfg_management);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.onRfgFragmentChanged();
            }
        });


        edit_list(view);

//        ingredient_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity)getActivity();
//                mainActivity.onRfgFragmentChanged(0);
//            }
//        });
//        rfg_management.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity)getActivity();
//                mainActivity.onRfgFragmentChanged(1);
//            }
//        });

        return view;
    }

    private void edit_list(View view){
        listview = view.findViewById(R.id.rgh_RecyclerView_rcp_list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        listview.setLayoutManager(layoutManager);
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

        adapter = new rcpAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
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