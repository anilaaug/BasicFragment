package com.example.anila.basicfragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;


public class Home2 extends AppCompatActivity{


    private final String[] PAGE_TITLES = new String[] {
            "Grid",
            "List"

    };
    private final Fragment[] PAGES = new Fragment[] {
            new Grid(),
            new MyListFragment()

    };
    ViewPager mViewPager;
    Toolbar mToolBar;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        mViewPager=findViewById(R.id.grid_viewpager);
        mToolBar=findViewById(R.id.toolbar);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_settings_white);
        mToolBar.setOverflowIcon(drawable);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("TestTwo");


        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.grid_tab);
        tabLayout.setupWithViewPager(mViewPager);
        for(int i=0;i<PAGE_TITLES.length;i++){
            tabLayout.getTabAt(i).setText(PAGE_TITLES[i]);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.settings_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent=new Intent(getApplicationContext(),SettingsActivity.class);
        startActivity(myIntent);
        return true;
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