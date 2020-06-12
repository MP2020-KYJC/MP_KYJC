package com.example.customactionbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Main_Page extends Fragment {
    //    1번 내용 저장 List
    private ArrayList<String> contextList;
    //    2번 내용저장 리스트
    private ArrayList<Main_ViewPager_rcp_today_list> rcp_main_List;
    //    옆에 보이기 위한 DP정도 설정
    private static final int DP = 15;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_page, container, false);

        setViewPager_Tip(view);
        setViewPager_Rcp(view);


        return view;
    }
    private void setViewPager_Tip(View view){
        ViewPager viewPager_tip = view.findViewById(R.id.main_ViewPager_tip);

        contextList = new ArrayList();
        contextList.add("첫번째 페이지");
        contextList.add("두번째 페이지");
        contextList.add("세번째 페이지");
        contextList.add("넷번째 페이지");
        contextList.add("다섯번째 페이지");

        viewPager_tip.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
//        어느정도 보일 것인지 이것을 통해 바꿈
        int margin = (int) (DP * density);

        viewPager_tip.setPadding(margin, 0, margin, 0);
        viewPager_tip.setPageMargin(margin/2);
        viewPager_tip.setAdapter(new Main_ViewPager_tip_adapter(mContext, contextList));
    }
    private void setViewPager_Rcp(View view){
        ViewPager viewPager_rcp = view.findViewById(R.id.main_ViewPager_rcp);

        rcp_main_List = new ArrayList<Main_ViewPager_rcp_today_list>();
        rcp_main_List.add(new Main_ViewPager_rcp_today_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        rcp_main_List.add(new Main_ViewPager_rcp_today_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        rcp_main_List.add(new Main_ViewPager_rcp_today_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));

        viewPager_rcp.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
//        어느정도 보일 것인지 이것을 통해 바꿈
        int margin = (int) (DP * density);

        viewPager_rcp.setPadding(margin, 0, margin, 0);
        viewPager_rcp.setPageMargin(margin/2);
        viewPager_rcp.setAdapter(new Main_ViewPager_rcp_today_adapter(mContext, rcp_main_List));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

}
