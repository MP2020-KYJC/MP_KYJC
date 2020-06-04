package com.example.term_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout); //xml , java 소스 연결

        SharedPreferences sf=getSharedPreferences("sFile",MODE_PRIVATE);
        final String login_info=sf.getString("login_info","");

//        SharedPreferences sf=getSharedPreferences("sFile",MODE_PRIVATE);
//        final String text=sf.getString("user_name","");
//
//        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show();
//
//        if(!text.equalsIgnoreCase("NO_USER_INFO"))
//        {
//            Toast.makeText(getApplicationContext(),text+"님 환영합니다!", Toast.LENGTH_SHORT).show();
//        }
//        SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {

//                Intent intent_recom = new Intent (getApplicationContext(),RecomActivity.class);
//                Intent intent_info=new Intent(getApplicationContext(), UserinfoActivity.class);
//
//                if(text.equalsIgnoreCase("NO_USER_INFO"))
//                {
//                    startActivity(intent_info); //접속했을때 사용자 관련 정보가 없다면 사용자 정보를 받아오는 Activity
//                }
//                else
//                {
//                    startActivity(intent_recom); //접속했을때 사용자 관련 정보가 있다면 추천탭을 열어줌
//                }

                /*
                로그인 여부를 저장하는 변수를 두고 그 변수가 로그인 (1) 을 뜻하면 바로 추천탭으로 넘어가고
                비로그인 (0) / 또는 다른 값 을 뜻하면 로그인 창으로 넘어간다.

                  if(login_info.equalsIgnoreCase("1"))
                {
                    startActivity(intent_recom);
                }
                else
                {
                    startActivity(intent_login);
                }

                 */
                Intent intent_login=new Intent(getApplicationContext(),LoginActivity.class);
                Intent intent_recom = new Intent (getApplicationContext(),RecomActivity.class);

                startActivity(intent_login);

                finish();

            }
        },3000); //3초 뒤에 Runner객체 실행하도록 함


    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
