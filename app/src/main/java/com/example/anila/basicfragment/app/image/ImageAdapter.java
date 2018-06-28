package com.example.anila.basicfragment.app.image;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.anila.basicfragment.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {

    List<Integer> mThumbIds = new ArrayList<Integer>();
    private Context mContext;
    private ImageAdapter mImageAdapter = this;

    public ImageAdapter(Context c, List<Integer> images) {
        mContext = c;
        mThumbIds = images;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView mainView, imgButton;
        final View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        grid = inflater.inflate(R.layout.custom_layout, null);
        mainView = grid.findViewById(R.id.mainImage);
        imgButton = grid.findViewById(R.id.closebutton);
        mainView.setImageResource(mThumbIds.get(position));
        mainView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mainView.setPadding(4, 4, 4, 4);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(mContext, view);
                menu.getMenuInflater().inflate(R.menu.menu, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        mThumbIds.remove(position);
                        mImageAdapter.notifyDataSetChanged();
                        Toast.makeText(mContext, "deleted position : " + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                menu.show();
            }
        });
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mContext, WebActivity.class);
                mContext.startActivity(myIntent);
            }
        });
        return grid;
    }
}

