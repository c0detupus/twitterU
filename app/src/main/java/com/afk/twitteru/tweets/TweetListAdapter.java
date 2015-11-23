package com.afk.twitteru.tweets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afk.twitteru.R;

import java.util.List;

/**
 * Created by c0detupus on 2015-10-16.
 */
public class TweetListAdapter extends BaseAdapter {

    private List<Tweet> tweetList;
    private LayoutInflater inflater;


    public TweetListAdapter(Context context, List<Tweet> tweetList) {
        inflater = LayoutInflater.from(context);
        this.tweetList = tweetList;

    }

    @Override
    public int getCount() {
        return tweetList.size();
    }

    @Override
    public Object getItem(int position) {
        return tweetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LinearLayout linearLayout;


        if (convertView == null) {
            linearLayout = (LinearLayout) inflater.inflate
                    (R.layout.dummy_row, parent, false);
        } else {
            linearLayout = (LinearLayout) convertView;
        }

        TextView tweetData = (TextView) linearLayout.findViewById(R.id.tweet_data);
//        ImageView icon = (ImageView)statsLayout.findViewById(R.id.icon);
//        icon.setBackgroundResource(R.drawable.ic_trophy);

        Tweet current = tweetList.get(position);
        tweetData.setText(current.getTweetData());

        linearLayout.setTag(position);


        return linearLayout;
    }
}