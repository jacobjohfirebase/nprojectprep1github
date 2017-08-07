package com.examplemobileappcompany.nprojectprep1github;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/3/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {



    List<String> svnUrls;

    public void setSvnUrls(List<String> svnUrls) {
        this.svnUrls = svnUrls;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(svnUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyHolder(View itemView) {

            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }


    }
}
