package com.example.recipe_detail_page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recipe_detail_page extends Fragment {
    private Context mContext;
    TextView ingredient, tag, time, title;
    ImageView recipe_image;
    ArrayList<context_list> context_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recipe_detail_page, container, false);
        title = view.findViewById(R.id.title);
        ingredient = view.findViewById(R.id.ingredient);
        time = view.findViewById(R.id.timer);
        tag = view.findViewById(R.id.tag);
        recipe_image = view.findViewById(R.id.recipe_image);

        ViewPager context = view.findViewById(R.id.context);
        //나중에 DB연결을 통한 Bundle로 해야할 것으로 보임
        title.setText("간장계란밥");
        ingredient.setText("재료: 간장, 계란, 밥");
        time.setText("소요시간: 10분");
        tag.setText("#간장 #계란 #밥");
        recipe_image.setImageResource(R.drawable.picture);

        context_list = new ArrayList<context_list>();

        context_list.add(new context_list(R.drawable.color1,"1단계", "1단계를 진행해 주세요"));
        context_list.add(new context_list(R.drawable.color2,"2단계", "2단계를 진행해 주세요"));
        context_list.add(new context_list(R.drawable.color3, "3단계", "3단계를 진행해 주세요"));

        context.setAdapter(new recipe_context_adapter(mContext, context_list));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


}
