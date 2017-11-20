package com.hybridappzone.dailynews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static android.R.attr.author;
import static java.security.AccessController.getContext;

/**
 * Created by swapna on 20/11/2017.
 */

public class NewsAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<NewsData> DataList;
    ImageLoader imageLoader = NewsController.getPermission().getImageLoader();
    private AdapterView.OnItemClickListener onItemClickListener;

    public NewsAdapter (Activity activity, List<NewsData> newsDataItems) {
        this.activity = activity;
        this.DataList = newsDataItems;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int location) {
        return DataList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.news_list, null);

        if (imageLoader == null)
            imageLoader = NewsController.getPermission().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbImage);
        final TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.desc);
        TextView published = (TextView) convertView.findViewById(R.id.publishedAt);



        final NewsData mData = DataList.get(position);
        thumbNail.setImageUrl(mData.getUrlToImage(), imageLoader);
        title.setText(mData.getTitle());
        published.setText(mData.getPublishedAt());
        description.setText(String.valueOf(mData.getDescription()));

        convertView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(activity, WebViewActivity.class);
                Bundle b = new Bundle();
                intent.putExtra("Url", mData.getUrl());
                activity.startActivity(intent);

            }
        });

        return convertView;
    }

}
