package com.example.customactionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class Main_ViewPager_tip_adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<String> contextList;

    public Main_ViewPager_tip_adapter() {

    }
//    생성자를 통해 값을 저장하는 법
    public Main_ViewPager_tip_adapter(Context context, ArrayList<String> contextList) {
        mContext = context;
        this.contextList = contextList;
    }

//    실제 적용 사항 이것을 통해 내용을 설정함
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.main_viewpager_tip, container, false);

            TextView titleTextView = (TextView) view.findViewById(R.id.main_ViewPager_tip_TextView) ;
            titleTextView.setText(contextList.get(position));

        }
        container.addView(view);

        return view;
    }


    //필수 적용사항 사용하진 않음
    @Override
    public int getCount() {
        return contextList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (View)o);
    }
}
