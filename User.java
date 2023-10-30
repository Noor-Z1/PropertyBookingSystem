import java.util.Date;

public class User {
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;


    public User() { }

    public User(int ID){
        this.userId = ID;
    }

    public User(int ID, Date dob, String firstName, String lastName){
        this.userId = ID;
        this.dateOfBirth = dob;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
