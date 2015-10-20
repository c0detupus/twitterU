package com.afk.twitteru.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.afk.twitteru.R;
import com.afk.twitteru.developer.Tweet;
import com.afk.twitteru.developer.TweetListAdapter;
import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;
import java.util.List;


public class StaggeredGridFragment extends Fragment {

    private StaggeredGridView staggeredGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_staggered_grid, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        staggeredGridView = (StaggeredGridView) getActivity().findViewById(R.id.grid_view);


        List<Tweet> tweets = new ArrayList<>();
        tweets.add(new Tweet("Hej"));
        tweets.add(new Tweet("what"));
        tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));
        tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));   tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));   tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));   tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));   tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));   tweets.add(new Tweet("are"));
        tweets.add(new Tweet("you doing here you are not supposed to be here"));
        tweets.add(new Tweet("What evs"));
        tweets.add(new Tweet("Shah"));

        staggeredGridView.setAdapter(new TweetListAdapter(getActivity().getApplicationContext(), tweets));

    }
}
