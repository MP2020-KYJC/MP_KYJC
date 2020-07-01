package com.example.jabu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_contents_list;
import static com.example.jabu.LoadingDBSection.all_hashtags_list;
import static com.example.jabu.LoadingDBSection.all_tips_list;


public class Rcp_page extends Fragment {
    private RecyclerView listview;
    private RcpAdapter adapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rcp_page, container, false);


//        recyclerView 참고:https://m.blog.naver.com/PostView.nhn?blogId=oaie&logNo=221378779560&proxyReferer=https:%2F%2Fwww.google.com%2F
        eating_alone(view);
        noodle(view);
        snack(view);
        taste(view);
        pan(view);

        return view;
    }


    private void eating_alone(View view){;
        listview = view.findViewById(R.id.rcp_RecyclerView_eating_alone);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<item_list> item_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("혼밥")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_contents_list.size();i++){
            if(all_contents_list.get(i).ctHashtag.contains(htId)){
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
//
                item_lists.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(mContext, item_lists);
        listview.setAdapter(adapter);
    }
    private void noodle(View view){;
        listview = view.findViewById(R.id.rcp_RecyclerView_noodle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<item_list> item_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("면")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_contents_list.size();i++){
            if(all_contents_list.get(i).ctHashtag.contains(htId)){
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
//
                item_lists.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(mContext, item_lists);
        listview.setAdapter(adapter);
    }
    private void snack(View view){;
        listview = view.findViewById(R.id.rcp_RecyclerView_snack);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<item_list> item_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("간단")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_contents_list.size();i++){
            if(all_contents_list.get(i).ctHashtag.contains(htId)){
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
//
                item_lists.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(mContext, item_lists);
        listview.setAdapter(adapter);
    }
    private void taste(View view){;
        listview = view.findViewById(R.id.rcp_RecyclerView_taste);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<item_list> item_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("입맛")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_contents_list.size();i++){
            if(all_contents_list.get(i).ctHashtag.contains(htId)){
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
//
                item_lists.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(mContext, item_lists);
        listview.setAdapter(adapter);
    }
    private void pan(View view){;
        listview = view.findViewById(R.id.rcp_RecyclerView_pan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
        String htId="";
        ArrayList<item_list> item_lists = new ArrayList<>();
        for(int i =0;i<all_hashtags_list.size();i++){
            if(all_hashtags_list.get(i).htName.equals("후라이팬")){
                htId = all_hashtags_list.get(i).getHtID();
            }
        }
        for(int i =0;i<all_contents_list.size();i++){
            if(all_contents_list.get(i).ctHashtag.contains(htId)){
                String Image = all_contents_list.get(i).ctImage;
                String[] icon_parse = Image.split("-");
                int icon = getResources().getIdentifier(icon_parse[0], "drawable", mContext.getPackageName());
//
                item_lists.add(new item_list(icon, all_contents_list.get(i).ctTitle, all_contents_list.get(i).ctID));
            }
        }

        adapter = new RcpAdapter(mContext, item_lists);
        listview.setAdapter(adapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
