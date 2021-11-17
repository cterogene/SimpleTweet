package com.codepath.apps.restclienttemplate.models;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TweetDao {
    @Query("SELECT Tweet.body as tweet_body, Tweet.createdAt AS tweet_createdAt, Tweet.id AS  tweet_id, User.*"+
            " FROM Tweet INNER JOIN User ON Tweet.userId = User.id ORDER BY Tweet.createdAt DESC LIMIT 5")
    List<TweetWithUser> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(Tweet... tweets);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(User... users);

}
