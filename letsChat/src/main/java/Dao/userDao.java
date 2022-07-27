package Dao;

import Model.User;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Random;

public enum userDao {
    instance;

    private userDao() {

    }
    //private Connection connection;
    private ResultSet lastQueryResult;

    public Connection makeConnection() throws SQLException {
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
        Connection connection = DriverManager.getConnection(
                url, username, password);
        return connection;
//        String sendThisQuery = "INSERT INTO \"user\" (username, email, password, verified, salt) " +
//                "VALUES('testing123', 'testing@.nl', 'secure', true, 'hash')";

        // String sentSelectAll = "SELECT * FROM \"user\"";

        //lastQueryResult = this.connection.prepareStatement(sentSelectAll).executeQuery();

       // while (lastQueryResult.next()) {

            //System.out.println(lastQueryResult.getString("username"));

        //}
        //connection.close();
    }

    //store new user (with verified false)
    public boolean insertUser(User user) throws SQLException, NoSuchAlgorithmException {
        String insertQuery = "INSERT INTO user(username, email, password, code, salt, verified)" + "VALUES(?,?,?,?,?,?)";
        Connection connection = makeConnection();
        PreparedStatement pstmt = connection.prepareStatement(insertQuery);
        //create random numbers for the salt
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = secureRandom.generateSeed(6);
        //use seed to create unique salt
        secureRandom.setSeed(seed);
        int salt = secureRandom.nextInt();
        String pepper = "m!st3ry";

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());

        //create a hash of SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String saltedPass = pepper + user.getPassword() + salt;

        //convert to bytes in UTF_8 standard and then hash.
        byte[] digest = md.digest(saltedPass.getBytes(StandardCharsets.UTF_8));
        //convert back to String
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

        pstmt.setString(3, sha256);

        //random number of 6 digit.
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String code = String.format("%06d", number);

        pstmt.setString(4, code);
        pstmt.setString(5, String.valueOf(salt));
        pstmt.setBoolean(6, false);
        int resultQuery = pstmt.executeUpdate();
        connection.close();
        if (resultQuery <= 0) {
            return false;
        }
        //create a profile for that user
        return true;
    }

    //set verification to true
    public boolean verifyUser(User user) throws SQLException {
        Connection connection = makeConnection();
        String updateQuery = "UPDATE user " +
                "SET verified = true " +
                "WHERE username = ? ";
        PreparedStatement pstmt = connection.prepareStatement(updateQuery);
        pstmt.setString(1, user.getUsername());
        int rowsAffected = pstmt.executeUpdate();
        connection.close();
        if (rowsAffected <= 0) {
            return false;
        }
        return true;
    }

    //check if username already exists
    //used for registration purposes
    public Boolean checkUserUsername(String username) throws SQLException {
        Connection connection = makeConnection();
        String query = "SELECT * " +
                "FROM \"user\" t " +
                "WHERE username = " + "'" + username + "'";
        Statement getstmt = connection.createStatement();
        ResultSet rs = getstmt.executeQuery(query);
        boolean exists = false;
        if (rs.next()) {
            exists = true;
        }
        return exists;
    }

    public Boolean checkUserEmail(String email) throws SQLException {
        Connection connection = makeConnection();
        String query = "SELECT * " +
                "FROM \"user\" t " +
                "WHERE email = " + "'" + email + "'";
        Statement getstmt = connection.createStatement();
        ResultSet rs = getstmt.executeQuery(query);
        boolean exists = false;
        if (rs.next()) {
            exists = true;
        }
        return exists;
    }

    //check if verified
    public Boolean checkUserVerification(String username) throws SQLException {
        Connection connection = makeConnection();
        String query = "SELECT verified " +
                "FROM \"user\" t " +
                "WHERE username = " + "'" + username + "'";
        Statement getstmt = connection.createStatement();
        ResultSet rs = getstmt.executeQuery(query);
        Boolean verified = rs.getBoolean("verified");
        return verified;
    }

    //check if passwords match
    public Boolean checkUserPassword(String username, String password) throws SQLException {
        Connection connection = makeConnection();
        String query = "SELECT verified " +
                "FROM \"user\" t " +
                "WHERE username = " + "'" + username + "'";
        Statement getstmt = connection.createStatement();
        ResultSet rs = getstmt.executeQuery(query);
        String actualPassword = rs.getString("password");
        if (actualPassword.equals(password)) {
            return true;
        }
        return false;
    }
}
