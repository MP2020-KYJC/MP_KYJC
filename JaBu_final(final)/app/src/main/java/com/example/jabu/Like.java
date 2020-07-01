package com.example.jabu;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_contents_list;

public class Like extends Activity {
    RecyclerView listview;
    private RcpAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.like);
        listview = findViewById(R.id.like_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        listview.setLayoutManager(layoutManager);
        ArrayList<item_list> itemList = new ArrayList<item_list>();

        for (int i = 0; i < all_contents_list.size(); i++) {
            if (all_contents_list.get(i).ctReference.equals("1")) {
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", getApplication().getPackageName());
                itemList.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(getApplicationContext(), itemList);
        listview.setAdapter(adapter);

    }
}
