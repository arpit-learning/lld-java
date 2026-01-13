package com.example.projects.socialMediaPosts;

public class SocialMediaPost {
    private String id;
    private String post;
    private Long userId;
    private Long timestamp;

    public SocialMediaPost(String id, String post, Long userId, Long timestamp) {
        this.id = id;
        this.post = post;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Id: " +
                id +
                ", UserId: " +
                userId +
                ", Post: " +
                post +
                ", Timestamp: " +
                timestamp;
    }
}