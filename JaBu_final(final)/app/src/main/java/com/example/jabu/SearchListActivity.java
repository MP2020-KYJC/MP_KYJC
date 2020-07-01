package com.example.jabu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchListActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    public int num=0;
    public int num2=0;
    public String htID;
    public String type;
    public String ctName;
    public String ctTitle;
    public String ingre_name;
    public int count=0;
    ListView list;
    public ArrayList<Object> searchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        list=(ListView)findViewById(R.id.listView1);

        Intent temp=getIntent();
        Bundle bundle=temp.getExtras();

        type=bundle.getString("type");

        if(type.equals("hashtag"))
        {
            htID=bundle.getString("htID");
            readContents(htID);
        }
        if(type.equals("ingre"))
        {
            ingre_name=bundle.getString("ingre_name");
            readIngre(ingre_name);
        }
        else
        {
            ctName=bundle.getString("ctName");
            readContents2(ctName);

        }

    }

    private void readContents(final String htId) {

        searchList = new ArrayList<>();

        mDatabase.child("Tips").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    final String hashtag=ds.getValue(Tips.class).tipHashtag;

                    if (hashtag.contains(htId)) {

                        ctTitle=ds.getValue(Tips.class).tipTitle;
                        searchList.add(ctTitle);

                    }

                }

                ArrayAdapter<Object> adapter = new ArrayAdapter<>(SearchListActivity.this, android.R.layout.simple_list_item_1, searchList);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        mDatabase.child("Contents").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    final String hashtag=ds.getValue(Contents.class).ctHashtag;

                    if (hashtag.contains(htId)) {

                        ctTitle=ds.getValue(Contents.class).ctTitle;
                        searchList.add(ctTitle);

                    }

                }

                ArrayAdapter<Object> adapter = new ArrayAdapter<>(SearchListActivity.this, android.R.layout.simple_list_item_1, searchList);
                list.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }

    private void readContents2(final String name) {

        searchList = new ArrayList<>();

        mDatabase.child("Tips").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot ds : dataSnapshot.getChildren()) {

                    final String title=ds.getValue(Tips.class).tipTitle;

                    if (title.contains(name)) {

                        ctTitle=ds.getValue(Tips.class).tipTitle;
                        searchList.add(ctTitle);

                        ArrayAdapter<Object> adapter = new ArrayAdapter<>(SearchListActivity.this, android.R.layout.simple_list_item_1, searchList);
                        list.setAdapter(adapter);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent intent=new Intent(getApplicationContext(),tip_detail_page.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("tipId",ds.getValue(Tips.class).tipID);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        });

                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        mDatabase.child("Contents").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot ds : dataSnapshot.getChildren()) {

                    final String title=ds.getValue(Contents.class).ctTitle;

                    if (title.contains(name)) {

                        ctTitle=ds.getValue(Contents.class).ctTitle;
                        searchList.add(ctTitle);

                        ArrayAdapter<Object> adapter = new ArrayAdapter<>(SearchListActivity.this, android.R.layout.simple_list_item_1, searchList);
                        list.setAdapter(adapter);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent intent=new Intent(getApplicationContext(),recipe_detail_page.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("ctId",ds.getValue(Contents.class).ctID);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        });

                    }

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }
    private void readIngre(final String name) {

        searchList = new ArrayList<>();

        mDatabase.child("Ingredients").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    final String title=ds.getValue(Ingredients.class).igName;

                    if (title.equals(name)) {

                        ctTitle=ds.getValue(Ingredients.class).igName;
                        searchList.add(ctTitle);

                    }

                }

                ArrayAdapter<Object> adapter = new ArrayAdapter<>(SearchListActivity.this, android.R.layout.simple_list_item_1, searchList);
                list.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


    }



}