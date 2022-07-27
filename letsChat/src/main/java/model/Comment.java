package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private int commentId;
    private String commentText;
    private int postId;
    private String userName;


    public Comment() {

    }


    public Comment(int commentId, String commentText, int postId, String userName) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.postId = postId;
        this.userName = userName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
