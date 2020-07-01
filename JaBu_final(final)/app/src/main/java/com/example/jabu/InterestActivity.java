package com.example.jabu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;


public class InterestActivity extends AppCompatActivity implements View.OnClickListener
{


    // 여러개의 버튼을 배열로 처리하기 위해 버튼에 대해 배열 선언을 함
    public Button[] mButton = new Button[12];
    public static String[] interest=new String[3];
    private DatabaseReference mDatabase;

    int button_click=0;

    // 각각 다르게 출력할 스트링을 넣어둘 리스트
    private ArrayList<String> mDataList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_layout);

        Intent intent=getIntent();
        final String id=intent.getExtras().getString("id");
        final String pw=intent.getExtras().getString("pw");
        final String name=intent.getExtras().getString("name");

        mDataList = new ArrayList<String>();

        mButton[0] = (Button) findViewById(R.id.button1);
        mButton[1] = (Button) findViewById(R.id.button2);
        mButton[2] = (Button) findViewById(R.id.button3);
        mButton[3] = (Button) findViewById(R.id.button4);
        mButton[4] = (Button) findViewById(R.id.button5);
        mButton[5] = (Button) findViewById(R.id.button6);
        mButton[6] = (Button) findViewById(R.id.button7);
        mButton[7] = (Button) findViewById(R.id.button8);
        mButton[8] = (Button) findViewById(R.id.button9);
        mButton[9] = (Button) findViewById(R.id.button10);
        mButton[10] = (Button) findViewById(R.id.button11);
        mButton[11] = (Button) findViewById(R.id.button12);

        Button btn_register=(Button)findViewById(R.id.bnt_register);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // 버튼들에 대한 클릭리스너 등록 및 각 버튼이 클릭되었을 때 출력될 메시지 생성(리스트)
        for(int i = 0 ; i < 12 ; i++)
        {
            // 버튼의 포지션(배열에서의 index)를 태그로 저장
            mButton[i].setTag(i);

            // 클릭 리스너 등록
            mButton[i].setOnClickListener(this);

        }

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(button_click==3)
                {

                    HashMap result = new HashMap<>();
                    result.put("myId", id);
                    result.put("myPassword", pw);
                    result.put("myName", name);
                    result.put("myHashtag",interest[0].substring(1)+"/"+interest[1].substring(1)+"/"+interest[2].substring(1));

                    registerNewuser(id, pw, name,interest[0].substring(1)+"/"+interest[1].substring(1)+"/"+interest[2].substring(1));
                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show();

                    Intent intent_login=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent_login);

                    finish();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"세개를 선택해주세요!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v)
    {

        // 클릭된 뷰를 버튼으로 받아옴
        Button newButton = (Button) v;

        // 향상된 for문을 사용, 클릭된 버튼을 찾아냄
        for(Button tempButton : mButton)
        {
            // 클릭된 버튼을 찾았으면
            if(tempButton == newButton)
            {
                // 위에서 저장한 버튼의 포지션을 태그로 가져옴
                int position = (Integer)v.getTag();

                // 태그로 가져온 포지션을 이용해 리스트에서 출력할 데이터를 꺼내서 토스트 메시지 출력
                //Toast.makeText(this, mButton[position].getText().toString(), Toast.LENGTH_SHORT).show();
                mButton[position].setSelected(true);
                interest[button_click]=mButton[position].getText().toString();
            }
        }

        button_click++;

        if(button_click==3)
        {
            Toast.makeText(this, "세개 다 골랐음!", Toast.LENGTH_SHORT).show();

        }

    }
    private void registerNewuser(String userId, String userPw, String userName,String userHashtag) {

        User user = new User(userId, userPw, userName, userHashtag);

        mDatabase.child("User").child(userId).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "<저장완료>", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "<저장실패>", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

