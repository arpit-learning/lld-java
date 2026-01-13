package com.example.projects.socialMediaPosts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FacebookAdapter fbAdapter = new FacebookAdapter();
        List<SocialMediaPost> posts = fbAdapter.fetchPosts(123L, 1234567890L);
        for (int i = 0; i < posts.size(); i++) {
            System.out.println("Facebook Post " + i + ": " + posts.get(i).toString());
        }

        TwitterAdapter twitterAdapter = new TwitterAdapter();
        List<SocialMediaPost> tweets = twitterAdapter.fetchPosts(123L, 1234567890L);
        for (int i = 0; i < tweets.size(); i++) {
            System.out.println("Twitter Tweet " + i + ": " + tweets.get(i).toString());
        }
    }
}
