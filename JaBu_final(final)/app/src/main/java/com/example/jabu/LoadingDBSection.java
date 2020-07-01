package com.example.jabu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoadingDBSection extends AppCompatActivity {

    public static ArrayList<Hashtags> all_hashtags_list = new ArrayList<Hashtags>();
    public static ArrayList<Tips> all_tips_list = new ArrayList<Tips>();
    public static ArrayList<Contents> all_contents_list = new ArrayList<Contents>();
    public static ArrayList<Ingredients> all_ingredient_list = new ArrayList<Ingredients>();
    DatabaseReference mDatabase;

    boolean content = false;
    boolean ingredient = false;
    boolean hashtag = false;
    boolean tip = false;

    Bundle sendData = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_d_b_section);

        store_ingredient();

    }

    //    재료가져오기
    private void store_ingredient() {
        //        DB구현부분
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Ingredients").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Image를 바로 불러오기 위해 Integer로 저장
                    String Image = ds.getValue(Ingredients.class).igImage;
                    String[] icon_parse = Image.split("-");
//                                            Toast.makeText(getApplicationContext(),icon_parse[0], Toast.LENGTH_SHORT).show();
                    int icon = getResources().getIdentifier(icon_parse[0], "drawable", getApplicationContext().getPackageName());
                    Ingredients ingre = new Ingredients();
                    ingre = ds.getValue(Ingredients.class);

                    all_ingredient_list.add(ingre);
                    Log.d("d","\nbefore send\n"+all_ingredient_list.toString());

                }
                store_Contents();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

    private void store_Contents() {
        //        DB구현부분
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Contents").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String Image = ds.getValue(Contents.class).ctImage;
                    String[] icon_parse = Image.split("-");
//                                            Toast.makeText(getApplicationContext(),icon_parse[0], Toast.LENGTH_SHORT).show();
                    int icon = getResources().getIdentifier(icon_parse[0], "drawable", getApplicationContext().getPackageName());
                     Contents content = new Contents();
                     content = ds.getValue(Contents.class);
                    all_contents_list.add(content);
                    Log.d("d","\nhand out before send\n"+all_ingredient_list.toString());
                }
                store_hashtag();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void store_hashtag() {
        //        DB구현부분
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Hashtags").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Hashtags hash = new Hashtags();
                    hash = ds.getValue(Hashtags.class);
                    all_hashtags_list.add(hash);
                }
                store_Tip();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    private void store_Tip() {
        //        DB구현부분
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Tips").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String Image = ds.getValue(Tips.class).tipImage;
                    String[] icon_parse = Image.split("-");
//                  Toast.makeText(getApplicationContext(),icon_parse[0], Toast.LENGTH_SHORT).show();
                    Tips tip = new Tips();
                    tip = ds.getValue(Tips.class);
                    int icon = getResources().getIdentifier(icon_parse[0], "drawable", getApplicationContext().getPackageName());
                    all_tips_list.add(tip);
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Bundle sendingData = new Bundle();
                sendingData.putSerializable("ingredient",all_ingredient_list);
                Log.d("d","\nfinal : \n"+all_ingredient_list.toString());
                sendingData.putSerializable("content",all_contents_list);
                sendingData.putSerializable("hastag",all_hashtags_list);
                sendingData.putSerializable("tip",all_tips_list);
                intent.putExtras(sendingData);
                startActivity(intent);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}