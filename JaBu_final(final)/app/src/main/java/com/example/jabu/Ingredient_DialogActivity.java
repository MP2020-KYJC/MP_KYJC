package com.example.jabu;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.example.jabu.LoadingDBSection.all_ingredient_list;

public class Ingredient_DialogActivity extends Activity {
    TextView dateAdded;     //재료를 추가한 날짜
    TextView expirationDate; //유통기한
    Button delete;             //삭제버튼
    ImageView selectedIngredientImg;  //선택된 재료 이미지
    TextView selectedIngredientText;    //선택된 재료 이름
    private String id;
    Calendar myCalendar;

    final int ADD_DATE = 1;
    final int EXP_DATE = 2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ingredient_dialog_activity);

        dateAdded = (TextView) findViewById(R.id.date_added);
        expirationDate = (TextView) findViewById(R.id.expiration_date);
        delete = (Button) findViewById(R.id.ingredient_delete_btn);
        selectedIngredientImg = (ImageView) findViewById(R.id.selected_ingredient_image);
        selectedIngredientText = (TextView) findViewById(R.id.selected_ingredient_name);

        //데이터 가져오기
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        for (int i = 0; i < all_ingredient_list.size(); i++) {
            if (all_ingredient_list.get(i).igID.equals(id)) {
                dateAdded.setText(all_ingredient_list.get(i).igAddedDate);
                expirationDate.setText(all_ingredient_list.get(i).igExpiration);
                selectedIngredientText.setText(all_ingredient_list.get(i).igName);
                selectedIngredientImg.setImageResource(getResources().getIdentifier(all_ingredient_list.get(i).igImage, "drawable", getApplicationContext().getPackageName()));
            }
        }

        //참고: https://wookkwang.tistory.com/entry/widget-EditText%EB%A5%BC-%ED%81%B4%EB%A6%AD%ED%95%98%EC%97%AC-DatePicker-%EB%B0%8F-TimePicker-%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8-%ED%8C%9D%EC%97%85%ED%95%98%EA%B8%B0
        //추가한 날짜 EditText 누르면
        dateAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(ADD_DATE);
            }
        });
        //유통기한 날짜 EditText 누르면
        expirationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(EXP_DATE);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < all_ingredient_list.size(); i++) {
                    if (all_ingredient_list.get(i).igID.equals(id)) {
                        Ingredients ig = new Ingredients();
                        ig = all_ingredient_list.get(i);
                        ig.setIsIsAdded("0");
                        all_ingredient_list.set(i, ig);
                    }
                }
                setResult(1);
                finish();
            }
        });

    }

    //날짜 선택 dialog 띄우기
    private void showDatePickerDialog(final int id) {
        myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(id);
            }
        };

        new DatePickerDialog(Ingredient_DialogActivity.this, myDatePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


    //날짜 업데이트(출력)
    private void updateLabel(int id) {
        String myFormat = "yy.MM.dd";    // 출력형식   18.11.28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
        if (id == ADD_DATE)
            dateAdded.setText(sdf.format(myCalendar.getTime()));
        else
            expirationDate.setText(sdf.format(myCalendar.getTime()));
    }

    //확인 버튼 클릭
    public void mOnClose(View v) {
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "변경사항 MainActivty에 전달/삭제관련 UI 구성해야 함");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }
}
