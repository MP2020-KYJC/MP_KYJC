package com.example.jabu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import static com.example.jabu.LoadingDBSection.all_contents_list;
import static com.example.jabu.LoadingDBSection.all_hashtags_list;
import static com.example.jabu.LoadingDBSection.all_ingredient_list;
import static com.example.jabu.LoadingDBSection.all_tips_list;

public class recipe_detail_page extends Activity {
    TextView ingredient, tag, time, title;
    ImageView recipe_image;
    ArrayList<context_list> context_list;
    Button likey;
    public ArrayList<String> like = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail_page);

        Intent intent = getIntent();
        final String ctId = intent.getStringExtra("ctId");

        title = findViewById(R.id.title);
        ingredient = findViewById(R.id.ingredient);
        time = findViewById(R.id.timer);
        tag = findViewById(R.id.tag);
        recipe_image = findViewById(R.id.recipe_image);
        likey = findViewById(R.id.like);

        ViewPager context = findViewById(R.id.context);
        context_list = new ArrayList<context_list>();
        //나중에 DB연결을 통한 Bundle로 해야할 것으로 보임
//        Toast.makeText(getApplicationContext(), ctId, Toast.LENGTH_SHORT);
        for(int i = 0;i < all_contents_list.size();i++){
            if(all_contents_list.get(i).ctID.equals(ctId)){
                title.setText(all_contents_list.get(i).ctTitle);
                String[] ingredients = all_contents_list.get(i).ctIg.split("-");
                String ingredient="";
                for(int j=0;j<ingredients.length;j++){
                    if(j == 0){
                        ingredient = ingredient + ingredients[j];
                    }else{
                        ingredient = ingredient + ", " + ingredients[j];
                    }

                }
                this.ingredient.setText(ingredient);
//                time.setText("소요시간: 20분");
                String hashTag="";
                String[] hashtag = all_contents_list.get(i).ctHashtag.split("-");
                for(int j = 0; j< all_hashtags_list.size();j++){
                    for(int k = 0;k<hashtag.length;k++){
                        if(hashtag[k].equals(all_hashtags_list.get(j).htID)){
                            hashTag = hashTag + "#" + all_hashtags_list.get(j).htName;
                        }
                    }
                }
                tag.setText(hashTag);
                String[] Image = all_contents_list.get(i).ctImage.split("-");
                String[] text = all_contents_list.get(i).ctText.split("-");
                recipe_image.setImageResource(getResources().getIdentifier(Image[0], "drawable", getApplicationContext().getPackageName()));
                for(int j =1;j<Image.length;j++){
                    int icon = getResources().getIdentifier(Image[j], "drawable", getApplicationContext().getPackageName());
                    context_list.add(new context_list(icon, j+"단계", text[j-1]));
                }
                context.setAdapter(new recipe_context_adapter(getApplicationContext(), context_list));
                if(all_contents_list.get(i).ctReference.equals("1")){
                    likey.setBackgroundResource(R.drawable.heart1);

                }else{
                    likey.setBackgroundResource(R.drawable.heart);
                }
            }
        }
        likey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                likey.setBackgroundResource(R.drawable.heart1);
                for(int i = 0;i < all_contents_list.size();i++){
                    if(all_contents_list.get(i).ctID.equals(ctId)){
                        if(all_contents_list.get(i).ctReference.equals("0")){
                            Contents ig = new Contents();
                            ig = all_contents_list.get(i);
                            ig.setCtReference("1");
                            all_contents_list.set(i, ig);
                            likey.setBackgroundResource(R.drawable.heart1);
                        }else{
                            Contents ig = new Contents();
                            ig = all_contents_list.get(i);
                            ig.setCtReference("0");
                            all_contents_list.set(i, ig);
                            likey.setBackgroundResource(R.drawable.heart);
                        }
                    }

                }

            }
        });
    }


}
