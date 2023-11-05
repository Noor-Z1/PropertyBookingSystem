
import java.util.Date;

public class Booking {

    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    private Property property;

    public Booking () {

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    public float totalCost() {
        return 0;
    }

    public String toString(){
        return "Booking [startDate=" + startDate + ", endDate=" + endDate + ", isPaid=" + isPaid + ", property=" + property + "]";
    }


}
