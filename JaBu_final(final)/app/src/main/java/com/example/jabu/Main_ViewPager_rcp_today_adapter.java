/* Main_ViewPager_rcp_today_adapter.java */
package com.example.jabu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_contents_list;

public class Main_ViewPager_rcp_today_adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<Main_ViewPager_rcp_today_list> contextList;

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    public Main_ViewPager_rcp_today_adapter() {

    }

    public Main_ViewPager_rcp_today_adapter(Context context, ArrayList<Main_ViewPager_rcp_today_list> contextList) {
        mContext = context;
        this.contextList = contextList;
    }

    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
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
            //TODO: 추가
            String temp = "";
            for (int i = 0; i < all_contents_list.size(); i++) {
                if (all_contents_list.get(i).ctID.equals(listViewItem.getId())) {
                    temp = all_contents_list.get(i).ctIg;
                    break;
                }
            }
            String[] ingredientsList = temp.split("-");
            String str = "재료 목록: ";
            for (int i = 0; i < ingredientsList.length; i++) {
                str += ingredientsList[i];
                if (i != ingredientsList.length - 1) {
                    str += ", ";
                }
            }
            descTextView.setText(str);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), recipe_detail_page.class);
                    int i = getItemPosition(view);
                    intent.putExtra("ctId", contextList.get(position).getId());
                    view.getContext().startActivity(intent);
                }
            });

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