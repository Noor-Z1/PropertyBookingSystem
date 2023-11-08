import java.util.Date;

/**
 * @author Noor Ul Zain
 * @version 1.0
 */
class Host {

    private int hostId;
    private String firsName;
    private String lastName;
    private Date registrationDate;

    public Host() {

    }
    public Host(int hostID){

    }
    public Host(int hostId, String firsName, String lastName, Date registrationDate){
        this.hostId = hostId;
        this.firsName = firsName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    public int getHostID() {
        return hostId;
    }

    public void setHostID(int hostId) {
        this.hostId = hostId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


}
