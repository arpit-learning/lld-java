package dev.arpit.BookMyShow.models;

import jakarta.persistence.Entity;

@Entity
public class Comment extends BaseModel {
    private String comment;
    private String commentedBy;

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
