package com.example.jabu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    private static String[][] item_list;
    int index = 1;
    Context mContext;

    private static final String ARG_SECTION_NUMBER = "section_number";

    //프래그먼트 호출방법
    public static PlaceholderFragment newInstance(int index, String[][] item_name) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        item_list = item_name;
        return fragment;
    }
    //섹션 숫자를 받아옴
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ingredient_add_fragment, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.ingredient_firstRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        FirstIngredientAdapter ingredientAdapter = new FirstIngredientAdapter(mContext, item_list[index], index);

        recyclerView.setAdapter(ingredientAdapter);
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}