package com.example.jabu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_ingredient_list;


public class Ingredient_Page extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageButton imageButton;
    IngredientAdapter_1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredient_page);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ingrdient_add.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ingredient_list();
    }


    private void ingredient_list() {
        recyclerView = findViewById(R.id.ingredient_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<item_list> itemList = new ArrayList<item_list>();
        for (int i = 0; i < all_ingredient_list.size(); i++) {
            if (all_ingredient_list.get(i).igIsAdded.equals("1")) {
                int icon = getResources().getIdentifier(all_ingredient_list.get(i).igImage, "drawable", getApplicationContext().getPackageName());
                itemList.add(new item_list(icon, all_ingredient_list.get(i).igName, all_ingredient_list.get(i).igID));
            }
        }
        adapter = new IngredientAdapter_1(this, itemList);
        recyclerView.setAdapter(adapter);
    }


}
