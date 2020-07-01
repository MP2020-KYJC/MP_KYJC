package com.example.jabu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class UserinfoActivity<imageView> extends AppCompatActivity {

    private static final int GET_GALLERY_IMAGE = 200;
    private EditText userName;
    private EditText userPhone;
    private EditText userEmail;
    private ImageView imageview;
    public static Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo_layout);

        final Button button=(Button)findViewById(R.id.btn_info);

        userName=(EditText)findViewById(R.id.user_name);
        userPhone=(EditText)findViewById(R.id.user_phone);
        userEmail=(EditText)findViewById(R.id.user_email);
        imageview=(ImageView)findViewById(R.id.user_img);

        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EditText의 내용을 받아옴
                String name=userName.getText().toString();
                String phone=userPhone.getText().toString();
                String email=userEmail.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("sFile",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name",name);
                editor.commit();

                Intent intent_interest = new Intent (getApplicationContext(),InterestActivity.class);
                startActivity(intent_interest);

                finish();

            }
        });

    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);
        }
    }

}