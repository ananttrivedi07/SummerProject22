package dao;

public class QueryFactory {


    public String insertPost( {
        return "INSERT INTO post VALUES('?', '?', '?', '?', '?')";
    }

    public String deletePost() {
        return "DELETE FROM post WHERE post_id = '?' AND userName = '?'";
    }

    public String editPost() {
        return "UPDATE post SET postcontent = '?' AND posttitle = '?' WHERE post_id = '?' AND userName = '?'";
    }


}
