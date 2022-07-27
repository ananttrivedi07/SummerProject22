package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private String userName;
    private String email;
    private String password;
    private boolean verified;
    private String salt;


    public User() {

    }


    public User(String userName, String email, String password, boolean verified, String salt) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verified = verified;
        this.salt = salt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
