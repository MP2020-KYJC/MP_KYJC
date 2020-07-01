package com.example.jabu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.example.jabu.LoadingDBSection.all_contents_list;
import static com.example.jabu.LoadingDBSection.all_hashtags_list;
import static com.example.jabu.LoadingDBSection.all_tips_list;

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
        tipRecommend(view);
        setViewPager_Rcp_second(view);

        return view;
    }
    private void setViewPager_Tip(View view){
        ViewPager viewPager_tip = view.findViewById(R.id.main_ViewPager_tip);
        Random random = new Random();   //랜덤 객체 생성(default: current time)

        contextList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            contextList.add(all_tips_list.get(random.nextInt(all_tips_list.size())).tipTitle);
        }

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

        Collections.sort(all_contents_list);        //내림차순 정렬

        for (int i = 0; i < all_contents_list.size(); i++) {
            String Image = all_contents_list.get(i).ctImage;
            String[] icon_parse = Image.split("-");
            int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
            rcp_main_List.add(new Main_ViewPager_rcp_today_list(icon,all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctIg,all_contents_list.get(i).ctID));
        }

        viewPager_rcp.setClipToPadding(false);

        float density = getResources().getDisplayMetrics().density;
//        어느정도 보일 것인지 이것을 통해 바꿈
        int margin = (int) (DP * density);

        viewPager_rcp.setPadding(margin, 0, margin, 0);
        viewPager_rcp.setPageMargin(margin/2);
        viewPager_rcp.setAdapter(new Main_ViewPager_rcp_today_adapter(mContext, rcp_main_List));
    }
    private void tipRecommend(View view){
        RecyclerView listview = view.findViewById(R.id.main_RecyclerView_tip);
        TipAdapter adapter;
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        Collections.sort(all_tips_list);        //내림차순 정렬
        for (int i = 0; i < all_tips_list.size(); i++) {
            tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
        }
        adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }

    private void setViewPager_Rcp_second(View view){
        ViewPager viewPager_rcp = view.findViewById(R.id.main_ViewPager_rcp_second);

        rcp_main_List = new ArrayList<Main_ViewPager_rcp_today_list>();
        Random random = new Random();   //랜덤 객체 생성(default: current time)

        contextList = new ArrayList();
        for (int i = 0; i < 6; i++) {       //6개만 랜덤으로 출력
            int N = random.nextInt(all_contents_list.size());
            String Image = all_contents_list.get(N).ctImage;
            String[] icon_parse = Image.split("-");
            int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
            rcp_main_List.add(new Main_ViewPager_rcp_today_list(icon,all_contents_list.get(N).ctTitle, all_contents_list.get(N).ctIg, all_contents_list.get(N).ctID));
        }

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
