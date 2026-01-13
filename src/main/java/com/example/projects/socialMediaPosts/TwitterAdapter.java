package com.example.projects.socialMediaPosts;

import com.example.projects.socialMediaPosts.external.TwitterApi;
import com.example.projects.socialMediaPosts.external.TwitterTweet;

import java.util.List;

public class TwitterAdapter implements SocialMediaAdapter {

    private final TwitterApi twitterApi;

    public TwitterAdapter() {
        twitterApi = new TwitterApi();
    }

    @Override
    public List<SocialMediaPost> fetchPosts(Long userId, Long timestamp) {
        List<TwitterTweet> fbPosts = twitterApi.getTweets(userId);
        return fbPosts.stream().map(i -> new SocialMediaPost(i.getId(), i.getTweet(), i.getUserId(), null)).toList();
    }

    @Override
    public void post(Long user, String status) {
        twitterApi.tweet(user, status);
    }
}
