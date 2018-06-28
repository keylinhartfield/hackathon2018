package jpmc.hackathon.usermanagement;

public class User {

    private String photoId;

    private String firstname;

    private String lastname;

    private String id;

    public User() {
    }

    public User(String id, String photoId, String firstname, String lastname) {
        this.photoId = photoId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id ;
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

    public String getId() {return id;}

    public void setId(String id){this.id=id;}
}
