package com.example.term_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class InterestActivity extends Activity implements View.OnClickListener
{
//    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    // 여러개의 버튼을 배열로 처리하기 위해 버튼에 대해 배열 선언을 함
    public Button[] mButton = new Button[6];
    public static String[] interest=new String[3];

    int button_click=0;

    // 각각 다르게 출력할 스트링을 넣어둘 리스트
    private ArrayList<String> mDataList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_layout);

        mDataList = new ArrayList<String>();

        mButton[0] = (Button) findViewById(R.id.button1);
        mButton[1] = (Button) findViewById(R.id.button2);
        mButton[2] = (Button) findViewById(R.id.button3);
        mButton[3] = (Button) findViewById(R.id.button4);
        mButton[4] = (Button) findViewById(R.id.button5);
        mButton[5] = (Button) findViewById(R.id.button6);

        // 버튼들에 대한 클릭리스너 등록 및 각 버튼이 클릭되었을 때 출력될 메시지 생성(리스트)
        for(int i = 0 ; i < 6 ; i++)
        {
            // 버튼의 포지션(배열에서의 index)를 태그로 저장
            mButton[i].setTag(i);

            // 클릭 리스너 등록
            mButton[i].setOnClickListener(this);

        }
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
            //Toast.makeText(this, interest[0], Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, interest[1], Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, interest[2], Toast.LENGTH_SHORT).show();

            SharedPreferences sf=getSharedPreferences("sFile",MODE_PRIVATE);

            final String name=sf.getString("user_name","");
            final String phone=sf.getString("user_phone","");
            final String email=sf.getString("user_email","");

//            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();

//            databaseReference.child("user_info").child("name").setValue(name);
//            databaseReference.child("user_info").child("phone").setValue(phone);
//            databaseReference.child("user_info").child("email").setValue(email);

            Intent intent_recom = new Intent (getApplicationContext(),RecomActivity.class);
            startActivity(intent_recom);
        }
    }
}

