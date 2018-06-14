package jpmc.hackathon.usermanagement;

public class User {

    private String photoId;

    private String firstname;

    private String lastname;

    public User() {
    }

    public User(String photoId, String firstname, String lastname) {
        this.photoId = photoId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
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
}
