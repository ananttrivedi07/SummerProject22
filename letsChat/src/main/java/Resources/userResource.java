package Resources;

import Dao.userDao;
import Model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static Security.sendEmail.sendEmail;

@Path("account")
public class userResource {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerUser(User user) throws SQLException, NoSuchAlgorithmException {
        //check if username exists
        if (userDao.instance.checkUserUsername(user.getUsername())) {
            return "username taken";
        }
        //check if email exists
        if (userDao.instance.checkUserEmail(user.getEmail())) {
            return "email taken";
        }
        userDao.instance.insertUser(user);
        sendEmail(user);
        return "registration successful!";
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public String verifyLogin(User user) throws NoSuchAlgorithmException, SQLException {
        String salt = user.getSalt();
        String pepper = "m!st3ry";

        if (!userDao.instance.checkUserUsername(user.getUsername())
        || !userDao.instance.checkUserVerification(user.getUsername())) {
            return "fail";
        }

        //create a hash of SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String saltedPass = pepper + user.getPassword() + salt;

        //convert to bytes in UTF_8 standard and then hash.
        byte[] digest = md.digest(saltedPass.getBytes(StandardCharsets.UTF_8));
        //convert back to String
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

        //check if passwords match
        if (userDao.instance.checkUserPassword(user.getUsername(), sha256)) {
            return "success";
        }
        return "fail";
    }
}
