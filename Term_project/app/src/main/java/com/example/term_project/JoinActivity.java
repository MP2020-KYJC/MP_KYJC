package com.example.term_project;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity<imageView> extends AppCompatActivity {

    private static final int GET_GALLERY_IMAGE = 200;
    private EditText userName;
    private EditText userPhone;
    private EditText userEmail;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_layout);

        final Button button=(Button)findViewById(R.id.btn_info);

        userName=(EditText)findViewById(R.id.user_name);
        userPhone=(EditText)findViewById(R.id.user_phone);
        userEmail=(EditText)findViewById(R.id.user_email);
        imageview=(ImageView)findViewById(R.id.user_img);

        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
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

            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }

    }

}