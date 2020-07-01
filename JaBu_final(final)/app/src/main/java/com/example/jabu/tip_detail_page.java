package com.example.jabu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.jabu.LoadingDBSection.all_tips_list;

public class tip_detail_page extends AppCompatActivity {

    TextView tipCt;
    ImageView tipImg;
    Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail_page);

        tipCt=(TextView)findViewById(R.id.tipContents);
        tipImg=(ImageView)findViewById(R.id.tipImage);
        btn_close=(Button)findViewById(R.id.btn_close);


        Intent intent = getIntent();
        String tipId = intent.getStringExtra("tipId");

        //Toast.makeText(getApplicationContext(),"여기"+tipId,Toast.LENGTH_SHORT).show();

        //사진 바꾸는거 필요
        for(int i = 0;i < all_tips_list.size();i++){

            if(all_tips_list.get(i).tipID.equals(tipId)){
                int icon = getResources().getIdentifier(all_tips_list.get(i).tipImage, "drawable", getApplicationContext().getPackageName());
                tipImg.setImageResource(icon);
                tipCt.setText(all_tips_list.get(i).tipText);
            }
        }

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}