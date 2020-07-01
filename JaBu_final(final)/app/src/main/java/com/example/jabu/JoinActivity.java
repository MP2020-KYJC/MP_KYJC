package com.example.jabu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JoinActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_layout);

        final EditText user_name = (EditText) findViewById(R.id.user_name);
        final EditText user_id = (EditText) findViewById(R.id.user_id);
        final EditText user_pw = (EditText) findViewById(R.id.user_pw);
        Button btn_info = (Button) findViewById(R.id.btn_info);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = user_name.getText().toString();
                String id = user_id.getText().toString();
                String pw = user_pw.getText().toString();

                Intent intent_interest = new Intent(getApplicationContext(), InterestActivity.class);

                intent_interest.putExtra("id", id);
                intent_interest.putExtra("pw", pw);
                intent_interest.putExtra("name", name);

                startActivity(intent_interest);
                finish();
            }
        });

    }
}
