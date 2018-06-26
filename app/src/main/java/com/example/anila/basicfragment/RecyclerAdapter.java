package com.example.anila.basicfragment;

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

import com.example.anila.basicfragment.model.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Data> horizontalList;
    Context context;
    RecyclerAdapter recyclerAdapter=this;
    public RecyclerAdapter(List<Data> horizontalList, Context context) {
        this.horizontalList = horizontalList;
        this.context = context;
    }

    @NonNull
        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolder holder, final int position) {
            holder.startImage.setImageResource(horizontalList.get(position).getImageId());
            holder.txtview.setText(horizontalList.get(position).getTxt());
            holder.closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu menu = new PopupMenu(context, view);
                    menu.getMenuInflater().inflate(R.menu.menu, menu.getMenu());
                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            horizontalList.remove(position);
                            recyclerAdapter.notifyDataSetChanged();
                            Toast.makeText(context, "deleted position : " + position, Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    });
                    menu.show();
                }
            });



            holder.startImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent=new Intent(context ,WebActivity.class);
                    context.startActivity(myIntent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    public Object getItem(int position) {

        return 0;
    }

    public long getItemId(int position) {

        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView startImage,closeButton;
        TextView txtview;
            public ViewHolder(View itemView) {
                        super(itemView);
                        startImage=itemView.findViewById(R.id.mainImageView);
                        closeButton=itemView.findViewById(R.id.deleteButton);
                        txtview= itemView.findViewById(R.id.textView);


                }
        }
}
