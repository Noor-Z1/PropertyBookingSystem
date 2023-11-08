import java.util.Date;

/**
 * @author Noor Ul Zain
 * @version 1.0
 */
public class Booking {

    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    private Property property;

   public Booking(){

   }

   public Booking(Date startDate, Date endDate, Property property){
       this.startDate = startDate;
       this.endDate = endDate;
       this.property = property;
       this.property.setAvailable(false);
   }

   public Booking(Date startDate, Date endDate, boolean isPaid){
       this.startDate = startDate;
       this.endDate = endDate;
       this.isPaid = isPaid;
       this.property = new Property();  // initializing the property but not assigning it yet
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
        this.property.setAvailable(false);
    }


    // complete this
    public float totalCost() {

        // first find the cost per day
        // then multiply the number of days by the cost per day



        return 0;
    }

    /**
     * This function overrides the toString() function of the object class
     * @return the string representation of the Booking object
     */

    public String toString(){
        return "Booking [startDate=" + startDate + ", endDate=" + endDate + ", isPaid=" + isPaid + ", property=" + property + "]";
    }


}
