package com.example.anila.basicfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserHomeActivity extends AppCompatActivity {


    private final String[] pageTitle = new String[]{
            "Login",
            "Signup"

    };
    private final Fragment[] pageArray = new Fragment[]{
            new LoginFragment(),
            new SignupFragment()

    };
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < pageTitle.length; i++) {
            tabLayout.getTabAt(i).setText(pageTitle[i]);
        }

    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageArray[position];
        }

        @Override
        public int getCount() {
            return pageArray.length;
        }
    }

}
