package com.example.jabu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowinfoActivity extends AppCompatActivity {

    public ImageView userImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userName=(TextView)findViewById(R.id.user_name);
        ImageView userImg=(ImageView)findViewById(R.id.user_img2);

        SharedPreferences sf=getSharedPreferences("sFile",MODE_PRIVATE);

        final String user_img=sf.getString("user_img"," ");
        final String user_name=sf.getString("user_name"," ");

        userName.setText("사용자 이름: "+user_img);


    }

}
