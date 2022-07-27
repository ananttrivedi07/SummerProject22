package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

    private int profileId;
    private String userName;
    private String country;
    private String city;
    private String firstName;
    private String telephoneNumber;
    private String bio;
    private boolean isPublic;


    public Profile() {

    }

    public Profile(int profileId, String userName, String country, String city, String firstName,
                   String telephoneNumber, String bio, boolean isPublic) {
        this.profileId = profileId;
        this.userName = userName;
        this.country = country;
        this.city = city;
        this.firstName = firstName;
        this.telephoneNumber = telephoneNumber;
        this.bio = bio;
        this.isPublic = isPublic;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
