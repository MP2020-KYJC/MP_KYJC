package com.example.jabu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class recipe_context_adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<context_list> contextList;

    public recipe_context_adapter() {

    }

    public recipe_context_adapter(Context context, ArrayList<context_list> contextList) {
        mContext = context;
        this.contextList = contextList;
    }

    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.context, container, false);


            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            ImageView iconImageView = (ImageView) view.findViewById(R.id.context_image) ;
            TextView titleTextView = (TextView) view.findViewById(R.id.context_title) ;
            TextView descTextView = (TextView) view.findViewById(R.id.context_detail_text) ;

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            context_list listViewItem = contextList.get(position);

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
