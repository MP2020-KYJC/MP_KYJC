package com.example.customactionbar;
/*
build.gradle에 dependencies 추가 해야 함
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    implementation 'com.android.support:design:28.0.0'

https://everyshare.tistory.com/21
참고
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    ImageView imageView_inDrawerHeader;
    View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        Glide.with(this)
                .load(R.drawable.profile_img_ps)
                .apply(new RequestOptions().circleCrop())
                .into(imageView_inDrawerHeader);


        //create Fragments
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

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
                        Toast.makeText(getApplicationContext(), "메뉴1이 선택되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "메뉴2가 선택되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "메뉴3이 선택되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu4:
                        Toast.makeText(getApplicationContext(), "메뉴4가 선택되었습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), "설정이 선택되었습니다.", Toast.LENGTH_SHORT).show();
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

        return super.onCreateOptionsMenu(menu);
    }

    //When back button is pressed.
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidMaifest.xml.

        switch (item.getItemId()) {
            case R.id.action_bar_search:
                //To Do: 검색했을 때 쿼리 구현
                Toast.makeText(this, "검색 쿼리 구현", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mypage_btn:
                //To Do: 마이페이지 버튼 눌렀을 때 이벤트 구현
                Toast.makeText(this, "마이페이지 버튼 눌림", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
