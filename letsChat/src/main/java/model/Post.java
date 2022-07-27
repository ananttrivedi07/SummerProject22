package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Post {

    private int postId;
    private int commentCount;
    private String postContent;
    private String postTitle;
    private String userName;

    public Post() {
    }

    /**
     * This function is a constructor for the class Posts.
     * @param postId id for the posts
     * @param commentCount count for a particular posts.
     * @param postContent contents for a particular posts.
     * @param postTitle title for a particular post.
     */
    public Post(int postId, int commentCount, String postContent, String postTitle, String userName) {
        this.postId = postId;
        this.commentCount = commentCount;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.userName = userName
    }

    // GETTERS AND SETTERS

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
