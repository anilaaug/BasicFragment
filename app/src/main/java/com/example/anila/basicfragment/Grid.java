package com.example.anila.basicfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class Grid extends Fragment {

    public Grid() {
        // Required empty public constructor
    }
    public static Grid newInstance(String param1, String param2) {
        Grid fragment = new Grid();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_grid,container, false);

        GridView gridview = view.findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(getContext()));
       gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

           }
       });
        return view;


    }







}
