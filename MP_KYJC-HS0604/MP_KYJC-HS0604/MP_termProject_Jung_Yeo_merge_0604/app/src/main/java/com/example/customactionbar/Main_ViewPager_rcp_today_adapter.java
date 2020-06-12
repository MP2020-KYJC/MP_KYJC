package com.example.customactionbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class Main_ViewPager_rcp_today_adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<Main_ViewPager_rcp_today_list> contextList;

    public Main_ViewPager_rcp_today_adapter() {

    }

    public Main_ViewPager_rcp_today_adapter(Context context, ArrayList<Main_ViewPager_rcp_today_list> contextList) {
        mContext = context;
        this.contextList = contextList;
    }

    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.main_viewpager_rcp_today, container, false);


            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView iconImageView = (ImageView) view.findViewById(R.id.main_ViewPager_rcp_ImageView) ;
            TextView titleTextView = (TextView) view.findViewById(R.id.main_ViewPager_rcp_textView1) ;
            TextView descTextView = (TextView) view.findViewById(R.id.main_ViewPager_rcp_textView2) ;

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            Main_ViewPager_rcp_today_list listViewItem = contextList.get(position);

            iconImageView.setImageResource(listViewItem.getIcon());
            titleTextView.setText(listViewItem.getTitle());
            descTextView.setText(listViewItem.getDesc());


        }
        container.addView(view);

        return view;
    }


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
