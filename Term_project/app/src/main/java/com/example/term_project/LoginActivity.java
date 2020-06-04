package com.example.term_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final Button bnt_login=(Button)findViewById(R.id.btn_login);
        final Button bnt_join=(Button)findViewById(R.id.btn_join);

        bnt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EditText의 내용을 받아옴
                String id=bnt_login.getText().toString();
                String pw=bnt_join.getText().toString();

                /* 여기서 파이어 베이스에 있는 정보와 일치하는지
                 * 확인해서 로그인 성공 혹은 로그인 실패를
                 * 나눠서 처리해야함
                 * 우선 무조건 로그인 성공으로 구현했음
                 */
                SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("login_info","1"); // 현재 로그인 상태를 유지하고 있다는 의미, 만약 로그아웃 버튼을 누르면 0으로 바꿔야함

                editor.commit();
                Intent intent_interest = new Intent (getApplicationContext(),RecomActivity.class);
                startActivity(intent_interest);
                finish();

            }
        });

        bnt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_interest = new Intent (getApplicationContext(),JoinActivity.class);
                startActivity(intent_interest);
                finish();

            }
        });
    }
}
