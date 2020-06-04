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

public class rcp_main_today_adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<rcp_main_today_list> contextList;

    public rcp_main_today_adapter() {

    }

    public rcp_main_today_adapter(Context context, ArrayList<rcp_main_today_list> contextList) {
        mContext = context;
        this.contextList = contextList;
    }

    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.rcp_main_today, container, false);


            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView1) ;
            TextView titleTextView = (TextView) view.findViewById(R.id.textView1) ;
            TextView descTextView = (TextView) view.findViewById(R.id.textView2) ;

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            rcp_main_today_list listViewItem = contextList.get(position);

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
