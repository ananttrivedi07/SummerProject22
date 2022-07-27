package dao;

import model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Service {

    private Map<String, Post> mapOfPosts = new HashMap<>();


    public void storeAllPosts(ResultSet resultSet) throws SQLException {
        Post post = new Post();

        while (resultSet.next()) {
            post.setPostId(resultSet.getInt("post_id"));
            post.setPostContent(resultSet.getString("postContent"));
            post.setCommentCount(resultSet.getInt("commentCount"));
            post.setPostTitle(resultSet.getString("postTitle"));
            post.setPostTitle(resultSet.getString("userName"));

            // <userName, Post>
            mapOfPosts.put(post.getUserName(), post);
        }
    }


    public Map<String, Post> getAllStoredPosts() {
        return mapOfPosts;
    }

}
