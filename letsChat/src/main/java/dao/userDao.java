package dao;

import org.postgresql.jdbc.PgConnection;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {

    private Connection connection;
    private ResultSet lastQueryResult;

    public void makeConnection() throws SQLException {
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

//        String sendThisQuery = "INSERT INTO \"user\" (username, email, password, verified, salt) " +
//                "VALUES('testing123', 'testing@.nl', 'secure', true, 'hash')";

        String sentSelectAll = "SELECT * FROM \"user\"";

        lastQueryResult = this.connection.prepareStatement(sentSelectAll).executeQuery();

        while (lastQueryResult.next()) {

            System.out.println(lastQueryResult.getString("username"));
            System.out.println(lastQueryResult.getString("username"));
            System.out.println(lastQueryResult.getString("username"));
            System.out.println(lastQueryResult.getString("username"));
            System.out.println(lastQueryResult.getString("username"));



        }
        connection.close();
    }




    public static void main(String[] args) throws SQLException {
        userDao userDao = new userDao();
        userDao.makeConnection();

    }


}
