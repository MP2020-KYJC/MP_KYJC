package com.example.jabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final String htName;
        htName="h002";
        findHashtag(htName);
    }

    private void findHashtag(final String name)
    {

        mDatabase.child("Hashtags").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    if (ds.getValue(Hashtags.class).htName.equals(name)) {

                        String htId=ds.getValue(Hashtags.class).htID;


                    }

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
    }

}