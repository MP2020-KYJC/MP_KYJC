package com.example.jabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Main_Page fragment1;
    Tip_Page fragment2;
    Rcp_page fragment3;
    Rfg_Page fragment4;
    private DatabaseReference mDatabase;
    ImageView imageView_inDrawerHeader;
    View headerView;
    TextView mypage_user_name;
    Intent intent;

    //Variable to store the data received as intent (LoadingDBSection.java에서 온 데이터를 저장할 변수)ㄴ
    public ArrayList<Hashtags> all_hashtags_list = new ArrayList<Hashtags>();
    public ArrayList<Tips> all_tips_list = new ArrayList<Tips>();
    public ArrayList<Contents> all_contents_list = new ArrayList<Contents>();
    public ArrayList<Ingredients> all_ingredient_list = new ArrayList<Ingredients>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Bundle receivedData = getIntent().getExtras();
        if (receivedData != null) {
            all_ingredient_list = (ArrayList<Ingredients>) receivedData.getSerializable("ingredient");
            all_contents_list = (ArrayList<Contents>) receivedData.getSerializable("content");
            all_hashtags_list = (ArrayList<Hashtags>) receivedData.getSerializable("hashtag");
            all_tips_list = (ArrayList<Tips>) receivedData.getSerializable("tips");


            Log.d("d", "\n" + all_ingredient_list.toString() + "\n");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Apply the toolbar as action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);    //remove the basic title
        //actionBar.setDisplayHomeAsUpEnabled(true);      //automatically make back button

        //display icon in action bar
        actionBar.setIcon(R.drawable.jabulogo_ex);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //get id of bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //get id of drawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //get id of navigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //get headerView from navigationView
        headerView = (View) navigationView.getHeaderView(0);
        //get id of profile_img from headerView(drawer_header)
        imageView_inDrawerHeader = (ImageView) headerView.findViewById(R.id.profile_img);
        //crop the image circularly and display the image into imageView in drawer header
        mypage_user_name = (TextView) headerView.findViewById(R.id.mypage_user_name);
        Glide.with(this)
                .load(R.drawable.profile_img_ps)
                .apply(new RequestOptions().circleCrop())
                .into(imageView_inDrawerHeader);


        //create Fragments
        fragment1 = new Main_Page();
        fragment2 = new Tip_Page();
        fragment3 = new Rcp_page();
        fragment4 = new Rfg_Page();

        SharedPreferences sf = getSharedPreferences("sFile", MODE_PRIVATE);
        final String user_name = sf.getString("user_name", " ");

        mypage_user_name.setText(user_name);

        //Set the fragment to be shown first.
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commitAllowingStateLoss();

        //When the icon of bottomNavigationView is selected, listener is added so that the desired fragment can be displayed.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Receives the id specified in menu_bottom.xml and generates different events for each id
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commitAllowingStateLoss();
                        return true;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commitAllowingStateLoss();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment3).commitAllowingStateLoss();
                        return true;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment4).commitAllowingStateLoss();
                        return true;
                    default:
                        return false;
                }

            }
        });

        //When the item of NavigationView(my page) is selected.
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu1:
                        intent = new Intent(getApplicationContext(), recipe_detail_page.class);
                        intent.putExtra("ctId", "r011");
                        startActivity(intent);
                        break;
                    case R.id.menu2:
                        intent = new Intent(getApplicationContext(), Like.class);
                        startActivity(intent);
                        break;
                    case R.id.menu4:
                        Toast.makeText(getApplicationContext(), "메뉴4가 선택되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), "로그아웃 되었습니다!", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences = getSharedPreferences("sFile", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("login_info", "0");
                        editor.commit();

                        intent = new Intent(getApplicationContext(), IntroActivity.class);
                        startActivity(intent);

                        finish();
                        break;
                }

                //When MenuItem is clicked, close the drawer.
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    //참고 링크: https://m.blog.naver.com/PostView.nhn?blogId=n_jihyeon&logNo=221196820428&proxyReferer=https:%2F%2Fwww.google.com%2F
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu(search)
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_bar_search).getActionView();
        //When search button is pressed, the length of the search box increases.

        searchView.setMaxWidth(Integer.MAX_VALUE);
        //When search button is pressed, show a hint to the search box.
        searchView.setQueryHint("메뉴, 재료, 해시태그로 검색해보세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {

                mDatabase = FirebaseDatabase.getInstance().getReference();

                if (query.contains("#")) {
                    mDatabase.child("Hashtags").addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for (DataSnapshot ds : dataSnapshot.getChildren()) {

                                if (ds.getValue(Hashtags.class).htName.equals(query.substring(1))) {

                                    String htId = ds.getValue(Hashtags.class).htID;
                                    Intent intent = new Intent(getApplicationContext(), SearchListActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("type", "hashtag");
                                    bundle.putString("htID", htId);
                                    intent.putExtras(bundle);
                                    startActivity(intent);

                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                } else {
                    Intent intent = new Intent(getApplicationContext(), SearchListActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "title");
                    bundle.putString("ctName", query);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }


                //Toast.makeText(getApplicationContext(),query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    //When back button is pressed.
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidMaifest.xml.

        switch (item.getItemId()) {
            case R.id.mypage_btn:
                //To Do: 마이페이지 버튼 눌렀을 때 이벤트 구현
                Toast.makeText(this, "마이페이지 버튼 눌림", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);

                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
