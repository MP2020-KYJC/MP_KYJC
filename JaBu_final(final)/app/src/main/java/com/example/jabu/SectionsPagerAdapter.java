package com.example.jabu;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_1, R.string.tab_2,R.string.tab_3, R.string.tab_4,
            R.string.tab_5,R.string.tab_6, R.string.tab_7, R.string.tab_8};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        String[][] item_list = {{"자주 사용하는 목록!"},
                {"과일", "잎채소", "열매채소", "뿌리채소", "버섯", "나물/허브류"},
                {"소고기", "돼지고기", "닭고기", "기타"},
                {"생선", "조개/갑각류", "해조류", "건어물"},
                {"견과류/특용작물", "주/잡곡", "밀/가루류"},
                {"장류", "기름류", "조미/향신류", "소스/드레싱", "소금/설탕/잼류"},
                {"면/만두/피자", "우유/요구르트", "치즈", "김치류", "밑반찬류","두부/묵류", "장아찌/절임류"},
                {"즉석조리식품", "햄/어묵", "캔", "빵", "떡", "커피/음료수/차", "과자/아이스크림"}};

        return PlaceholderFragment.newInstance(position, item_list);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    //페이지 수
    @Override
    public int getCount() {
        // Show 2 total pages.
        return 8;
    }
}