package com.example.fragment1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
//    1번 내용 저장 List
    private ArrayList<String> contextList;
//    2번 내용저장 리스트
    private ArrayList<rcp_main_today_list> rcp_main_List;
//    옆에 보이기 위한 DP정도 설정
    private static final int DP = 15;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment1, container, false);

        ViewPager tip_top = view.findViewById(R.id.main_tip_top);
        ViewPager rcp_today = view.findViewById(R.id.main_rcp_today);


        contextList = new ArrayList();
        contextList.add("첫번째 페이지");
        contextList.add("두번째 페이지");
        contextList.add("세번째 페이지");
        contextList.add("넷번째 페이지");
        contextList.add("다섯번째 페이지");


        rcp_main_List = new ArrayList<rcp_main_today_list>();


        rcp_main_List.add(new rcp_main_today_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        rcp_main_List.add(new rcp_main_today_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        rcp_main_List.add(new rcp_main_today_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));

        //옆에 약간 보이게 설정
        tip_top.setClipToPadding(false);
        rcp_today.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
//        어느정도 보일 것인지 이것을 통해 바꿈
        int margin = (int) (DP * density);
//        1번
        tip_top.setPadding(margin, 0, margin, 0);
        tip_top.setPageMargin(margin/2);
//        2번
        rcp_today.setPadding(margin, 0, margin, 0);
        rcp_today.setPageMargin(margin/2);

//        Adapter 적용
        tip_top.setAdapter(new tip_main_top_adapter(mContext, contextList));
        rcp_today.setAdapter(new rcp_main_today_adapter(mContext, rcp_main_List));



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


}
