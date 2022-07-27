package dao;

import java.sql.*;

public class QueryMan {

    private ResultSet lastResultSet;
    private Connection connection;
    private QueryFactory queryFactory;


    public QueryMan() throws SQLException {
        String url = "jdbc:postgresql://ec2-54-76-43-89.eu-west-1.compute.amazonaws.com:5432/ddrf9ig5a5v8lu";
        String username = "eymuwjdtgbyuiu";
        String password = "b48c3ada9a73b4f2b024c019406a30eb3142fb1a48cd12e26461f1dbde6d48ce";
        // name of the driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading drivers" + cnfe);
        }
        // establishing the connection
        this.connection = DriverManager.getConnection(
                url, username, password);

        // setting QueryFactory
        this.queryFactory = new QueryFactory();
    }


    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public ResultSet getLastResultSet() {
        return this.lastResultSet;
    }


    public void executeInsertPost(
            String insertQuery,
            int postId,
            String postContent,
            int commentCount,
            String postTitle,
            String userName) throws SQLException {


        PreparedStatement insertThis = connection.prepareStatement(insertQuery);

        insertThis.setInt(1, postId);
        insertThis.setString(2, postContent);
        insertThis.setInt(3, commentCount);
        insertThis.setString(4, postTitle);
        insertThis.setString(5, userName);

        // executing this statement
        insertThis.executeQuery();
        closeConnection();
    }












}
