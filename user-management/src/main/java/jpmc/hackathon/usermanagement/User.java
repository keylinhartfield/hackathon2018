package jpmc.hackathon.usermanagement;

public class User {

    private String photoId;

    private String firstname;

    private String lastname;

    private String id;

    private boolean deleted;

    public User() {
    }

    public User(String id, String photoId, String firstname, String lastname, boolean deleted) {
        this.photoId = photoId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id ;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
