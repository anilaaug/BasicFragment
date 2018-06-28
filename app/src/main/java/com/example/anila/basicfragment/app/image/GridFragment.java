package com.example.anila.basicfragment.app.image;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.anila.basicfragment.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridFragment extends Fragment {

    public GridFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Integer> imageList = new ArrayList<>(Arrays.asList
                (R.drawable.sample_bird, R.drawable.sample_bear,
                        R.drawable.sample_cat, R.drawable.sample_dog, R.drawable.sample_ucbrowser,
                        R.drawable.sample_wild));

        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        GridView gridview = view.findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(getContext(), imageList));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }
}
