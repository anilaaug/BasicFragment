package com.example.anila.basicfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Home2 extends AppCompatActivity{


    private final String[] PAGE_TITLES = new String[] {
            "Grid",
            "List"

    };
    private final Fragment[] PAGES = new Fragment[] {
            new Grid(),
            new List()

    };
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        viewPager=findViewById(R.id.grid_viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        getSupportActionBar().hide();
        TabLayout tabLayout = findViewById(R.id.grid_tab);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<PAGE_TITLES.length;i++){
            tabLayout.getTabAt(i).setText(PAGE_TITLES[i]);
        }

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }
    }

}