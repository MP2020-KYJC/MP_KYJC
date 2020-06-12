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

public class Tip_Page extends Fragment {
    private RecyclerView listview;
    private TipAdapter adapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tip_page, container, false);

//        recyclerView 참고:https://m.blog.naver.com/PostView.nhn?blogId=oaie&logNo=221378779560&proxyReferer=https:%2F%2Fwww.google.com%2F
        trash(view);
        interior(view);
        clothing(view);

        return view;
    }

    private void trash(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_trash);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
//        여기까지

        adapter = new TipAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
    }

    private void interior(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_interior);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
//        여기까지

        adapter = new TipAdapter(mContext, itemList, onClickItem);
        listview.setAdapter(adapter);
    }

    private void clothing(View view){
        listview = view.findViewById(R.id.tip_RecyclerView_clothing);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);
//        DB구현부분
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
//        여기까지

        adapter = new TipAdapter(mContext, itemList, onClickItem);
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
