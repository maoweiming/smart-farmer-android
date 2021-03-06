package com.beanu.sf.ui.layer2.recycleview.support;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beanu.arad.support.recyclerview.adapter.BaseAdapter;
import com.beanu.sf.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 列表适配器
 * Created by Beanu on 2016/12/16.
 */

public class RecyclerAdapter extends BaseAdapter<News, RecyclerAdapter.ViewHolder> {

    public RecyclerAdapter(Context context, List<News> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView mTxtTitle;
        private TextView mTxtDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_news);
            mTxtTitle = (TextView) itemView.findViewById(R.id.txt_item_news_title);
            mTxtDesc = (TextView) itemView.findViewById(R.id.txt_item_news_desc);
        }

        private void bind(News item) {
            Glide.with(mContext).load(item.getImgPath()).into(img);
            mTxtTitle.setText(item.getTitle());
            mTxtDesc.setText(item.getDesc());
        }
    }
}