package com.example.projects.bookMyShowClassDiagramAssignment.models;

public class Comment extends BaseModel {
    private String comment;
    private String commentedBy;

    public Comment() {
    }

    public Comment(String comment, String commentedBy) {
        this.comment = comment;
        this.commentedBy = commentedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }
}
