package com.example.jabu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Ingrdient_add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredient_add);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        SearchView searchView = (SearchView) findViewById(R.id.ingredient_search);
        //검색창 확장
        searchView.onActionViewExpanded();
        //키보드 안띄움
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Intent intent = new Intent(getApplicationContext(), SearchListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ingre_name", query);
                bundle.putString("type", "ingre");
                intent.putExtras(bundle);
                startActivity(intent);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


}