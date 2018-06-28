package com.example.anila.basicfragment.app.image;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anila.basicfragment.R;
import com.example.anila.basicfragment.model.Data;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Data> mImageList;
    private Context mcontext;
    private RecyclerAdapter mrecyclerAdapter = this;

    public RecyclerAdapter(List<Data> horizontalList, Context context) {
        this.mImageList = horizontalList;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolder holder, final int position) {
        holder.mainImage.setImageResource(mImageList.get(position).getImageId());
        holder.txtView.setText(mImageList.get(position).getTxt());
        holder.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(mcontext, view);
                menu.getMenuInflater().inflate(R.menu.menu, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        mImageList.remove(position);
                        mrecyclerAdapter.notifyDataSetChanged();
                        Toast.makeText(mcontext, "deleted position : " + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                menu.show();
            }
        });


        holder.mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mcontext, WebActivity.class);
                mcontext.startActivity(myIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    public Object getItem(int position) {

        return 0;
    }

    public long getItemId(int position) {

        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage, closeButton;
        TextView txtView;

        public ViewHolder(View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.mainImageView);
            closeButton = itemView.findViewById(R.id.deleteButton);
            txtView = itemView.findViewById(R.id.textView);


        }
    }
}
