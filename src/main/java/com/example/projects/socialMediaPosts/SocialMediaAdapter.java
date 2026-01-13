package com.example.projects.socialMediaPosts;

import java.util.List;

public interface SocialMediaAdapter {
    List<SocialMediaPost> fetchPosts(Long userId, Long timestamp);

    void post(Long user, String status);
}