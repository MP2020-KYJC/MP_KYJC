package com.example.jabu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_hashtags_list;
import static com.example.jabu.LoadingDBSection.all_tips_list;


public class Tip_Page extends Fragment {
    private RecyclerView listview;
    private TipAdapter adapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tip_page, container, false);

        laundry(view);
        food(view);
        daiso(view);
        trash(view);
        room_clean(view);
        bathroom_clean(view);
        toilet(view);

//        recyclerView 참고:https://m.blog.naver.com/PostView.nhn?blogId=oaie&logNo=221378779560&proxyReferer=https:%2F%2Fwww.google.com%2F


        return view;
    }


    private void laundry(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_laundry);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("빨래")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
//    TODO
    private void food(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_foodr);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("음식")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
    private void daiso(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_daiso);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("다이소")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
    private void trash(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_trash);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("쓰레기")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
    private void room_clean(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_room_clean);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("방청소")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        if(!tip_lists.isEmpty())
            adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
    private void bathroom_clean(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_bathroom_clean);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.contains("욕실청소")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        if(!tip_lists.isEmpty())
            adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
    private void toilet(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_toilet);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<Tip_list> tip_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("화장실")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_tips_list.size();i++){
            if(all_tips_list.get(i).tipHashtag.contains(htId)){
                tip_lists.add(new Tip_list(all_tips_list.get(i).tipTitle, all_tips_list.get(i).tipID));
            }
        }
        if(!tip_lists.isEmpty())
            adapter = new TipAdapter(mContext, tip_lists);
        listview.setAdapter(adapter);
    }
//TODO
//    private void kitchen(View view) {
//        listview = view.findViewById(R.id.tip_RecyclerView_kitchen);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
//        listview.setLayoutManager(layoutManager);
//        if (!tip_view_list.get(7).isEmpty())
//            adapter = new TipAdapter(mContext, tip_view_list.get(7));
//        listview.setAdapter(adapter);
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
