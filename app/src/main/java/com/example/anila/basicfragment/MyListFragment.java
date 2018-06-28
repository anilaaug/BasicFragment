package com.example.anila.basicfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anila.basicfragment.model.Data;

import java.util.ArrayList;
import java.util.List;

public class MyListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;;
    private List<Data> mdata;

    public MyListFragment() {
        // Required empty public constructor
        }

    public static MyListFragment newInstance(String param1, String param2) {
        MyListFragment fragment = new MyListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
          }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_list,container, false);

        mRecyclerView=view.findViewById(R.id.recyclerview);
        mLayoutManager=new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mdata=new ArrayList<>();
        fillWithData();
        mAdapter = new RecyclerAdapter(mdata,getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
    public void fillWithData() {

        mdata.add(new Data( R.drawable.sample_bear, "Bear"));
        mdata.add(new Data( R.drawable.sample_bird, "Bird"));
        mdata.add(new Data( R.drawable.sample_cat, "Cat"));
        mdata.add(new Data( R.drawable.sample_dog, "Dog"));
        mdata.add(new Data( R.drawable.sample_ucbrowser, "squirrel"));
        mdata.add(new Data( R.drawable.sample_wild, "Beach"));
    }




}
