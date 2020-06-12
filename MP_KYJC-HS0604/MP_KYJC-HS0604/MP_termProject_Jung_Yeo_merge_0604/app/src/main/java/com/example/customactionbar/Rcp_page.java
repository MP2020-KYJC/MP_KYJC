package com.example.customactionbar;

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
        drinking_alone(view);
        snack(view);

        return view;
    }

    private void eating_alone(View view){
        listview = view.findViewById(R.id.rcp_RecyclerView_eating_alone);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<Rcp_item_list> itemList = new ArrayList<Rcp_item_list>();
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
//        여기까지

        adapter = new RcpAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
    }
    private void drinking_alone(View view){
        listview = view.findViewById(R.id.rcp_RecyclerView_drinking_alone);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<Rcp_item_list> itemList = new ArrayList<Rcp_item_list>();
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
//        여기까지

        adapter = new RcpAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
    }

    private void snack(View view){
        listview = view.findViewById(R.id.rcp_RecyclerView_snack);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<Rcp_item_list> itemList = new ArrayList<Rcp_item_list>();
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.tomato, "토마토 스파게티", "토마토, 스파게티, 등등"));
        itemList.add(new Rcp_item_list(R.drawable.toast,"토스트", "식빵,햄, 계란 등등"));
        itemList.add(new Rcp_item_list(R.drawable.spammayo,"스팸마요덮밥", "스팸, 마요네즈, 밥, 등등"));
//        여기까지

        adapter = new RcpAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
    }

    //클릭시 실행 화면 구현 adpater코드 수정해야할 것으로 보임
    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
