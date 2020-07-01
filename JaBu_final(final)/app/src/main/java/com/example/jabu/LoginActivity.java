package com.example.jabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        final EditText user_id=(EditText)findViewById(R.id.user_id);
        final EditText user_pw=(EditText)findViewById(R.id.user_pw);
        final Button btn_login=(Button)findViewById(R.id.btn_login);
        final Button btn_join=(Button)findViewById(R.id.btn_join);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EditText의 내용을 받아옴
                final String id=user_id.getText().toString();
                final String pw=user_pw.getText().toString();

                mDatabase = FirebaseDatabase.getInstance().getReference();

                mDatabase.child("User").child(id).addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue(User.class) != null){
                            User user = dataSnapshot.getValue(User.class);
                            if(id.equals(user.myId)) {
                                if(pw.equals(user.myPassword)) {
                                    Toast.makeText(getApplicationContext(), user.myName+"님 환영합니다!", Toast.LENGTH_SHORT).show();
                                    Intent intent_recom = new Intent (getApplicationContext(),LoadingDBSection.class);
                                    startActivity(intent_recom);

                                    SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putString("login_info","1"); // 현재 로그인 상태를 유지하고 있다는 의미, 만약 로그아웃 버튼을 누르면 0으로 바꿔야함
                                    editor.putString("user_name",user.myName);

                                    editor.commit();

                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "패스워드를 확인해주세요!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "아이디를 확인해주세요!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });

            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_join = new Intent (getApplicationContext(),JoinActivity.class);
                startActivity(intent_join);
                finish();

            }
        });
    }
}