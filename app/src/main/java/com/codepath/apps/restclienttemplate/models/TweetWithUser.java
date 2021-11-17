package com.codepath.apps.restclienttemplate.models;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.room.Embedded;

public class TweetWithUser {
    @Embedded
    User user;
    @Embedded(prefix = "tweet_")
    Tweet tweet;

    public  static List<Tweet> getTweetList(List<TweetWithUser> tweetWithUsers) {
        List<Tweet> tweets = new ArrayList<>();
        for (int i=0; i< tweetWithUsers.size();i++){
            Tweet tweet = tweetWithUsers.get(i).tweet;
            tweet.user = tweetWithUsers.get(i).user;
            tweets.add(tweet);
        }
        return tweets;
    }
}
