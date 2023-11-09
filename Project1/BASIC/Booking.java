package Project1.BASIC;

import java.util.Date;

/** Represents a Booking class that stores information about a booking
 *  and the Property associated with the booking
 * @author Noor Ul Zain
 * @version 1.0
 * @see Property
 */
class Booking {

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

    }

    /**
     * This function computes the total cost of the particular booking
     * @return the total cost of the booking
     */
    public float totalCost() {

        // first find the number of days
        // then multiply the number of days by the cost per day

        float a = endDate.getTime() - startDate.getTime();
        //to convert the time to days
        float days = a / (1000 * 60 * 60 * 24);
        return days * property.getPricePerDay();

    }

    /**
     * This function overrides the toString() function of the object class
     * @return the string representation of the Booking object
     */
    public String toString(){
        return "Booking: startDate is " + startDate.toString() + ", endDate is" + endDate.toString() + ", isPaid: " + isPaid + ", property: " + property.toString() + ".";
    }


}
