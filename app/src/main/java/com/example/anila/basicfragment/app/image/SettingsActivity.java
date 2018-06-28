package com.example.anila.basicfragment.app.image;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.anila.basicfragment.R;

public class SettingsActivity extends AppCompatActivity {
    Toolbar mToolBar;

    @Override
    public boolean onSupportNavigateUp() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mToolBar = findViewById(R.id.setting_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Settings");
        SettingsScreen fragment = new SettingsScreen();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.linear_layout, fragment);
        fragmentTransaction.commit();
        mToolBar.setNavigationIcon(getResources().getDrawable(R.drawable.back_button));
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), ImageHomeActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public static class SettingsScreen extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}