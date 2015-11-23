package com.afk.twitteru.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afk.twitteru.R;
import com.afk.twitteru.tweets.Tweet;
import com.afk.twitteru.tweets.TweetListAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Will handle load list of tweets in a listview
 */
public class ListViewFragment extends Fragment {

    private ListView tweetListView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_list_view, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tweetListView = (ListView) getActivity().findViewById(R.id.tweetListView);


        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet("Hej"));
        tweets.add(new Tweet("what"));
        tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));


        tweetListView.setAdapter(new TweetListAdapter(getActivity().getApplicationContext(), tweets));
    }
}
