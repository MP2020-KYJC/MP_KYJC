package com.example.jabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;


public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout); //xml , java 소스 연결

        SharedPreferences sf=getSharedPreferences("sFile",MODE_PRIVATE);
        final String login_info=sf.getString("login_info"," ");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {

                //로그인이 이미 되어있다는 의미
                if(login_info.equalsIgnoreCase("1"))
                {
                    Intent intent_recom=new Intent(getApplicationContext(),LoadingDBSection.class);
                    startActivity(intent_recom);

                }
                else
                {
                    Intent intent_login=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent_login);
                }

            }
        },3000); //3초 뒤에 Runner객체 실행하도록 함

    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}