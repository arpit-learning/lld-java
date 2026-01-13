package com.example.projects.socialMediaPosts;

import com.example.projects.socialMediaPosts.external.FacebookApi;
import com.example.projects.socialMediaPosts.external.FacebookPost;

import java.util.List;

public class FacebookAdapter implements SocialMediaAdapter {

    private final FacebookApi facebookApi;

    public FacebookAdapter() {
        facebookApi = new FacebookApi();
    }

    @Override
    public List<SocialMediaPost> fetchPosts(Long userId, Long timestamp) {
        List<FacebookPost> fbPosts = facebookApi.fetchFacebookPosts(userId, timestamp);
        return fbPosts.stream().map(i -> new SocialMediaPost(i.getId(), i.getStatus(), i.getUserId(), i.getTimestamp())).toList();
    }

    @Override
    public void post(Long user, String status) {
        facebookApi.postFacebookStatus(user, status);
    }

}
