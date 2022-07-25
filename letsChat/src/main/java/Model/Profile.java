package Model;

public class Profile {
    int profile_id;
    String username;
    String country;
    String city;
    String firstname;
    String lastname;
    String telephone_nr;
    String bio;
    boolean ispublic;

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone_nr() {
        return telephone_nr;
    }

    public void setTelephone_nr(String telephone_nr) {
        this.telephone_nr = telephone_nr;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isIspublic() {
        return ispublic;
    }

    public void setIspublic(boolean ispublic) {
        this.ispublic = ispublic;
    }
}
