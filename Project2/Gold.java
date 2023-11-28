package BASIC.Project2;


/**
 * This class extends the Customer class and represents a Gold Customer.
 * @author Noor Ul Zain
 * @version 1.0
 * @see Customer
 * @see User
 */
public class Gold extends Customer {
    private int goldLevel;

    /**
     * This is the constructor for the Gold class.
     * @param ID This is the ID of the customer.
     * @param preferredPaymentMethod This is the preferred payment method of the customer.
     * @param goldLevel This is the gold level of the customer.
     */
    public Gold(int ID, String preferredPaymentMethod, int goldLevel) {
        super(ID, preferredPaymentMethod);
        this.goldLevel = goldLevel;
    }

    /**
     This is overloaded constructor for the Gold class.
     @param goldLevel This is the gold level of the customer.
     */
    public Gold(int goldLevel) {
        super();
        this.goldLevel = goldLevel;
    }

    public int getGoldLevel() {
        return goldLevel;
    }

    public void setGoldLevel(int goldLevel) {
        this.goldLevel = goldLevel;
    }


    /**
     * This method overrides the abstract method in the Customer class
     * @return the discount percentage for a gold customer
     */
    @Override
    double discountPercentage() {
        if (goldLevel == 1) {
            return 0.01;
        } else if (goldLevel == 2) {
            return 0.02;
        } else {
            return 0.03;
        }
    }

    /**
     * This method returns the Gold description
     * by overriding the toString() method of the base class
     * @return the string representation of Gold
     */
    @Override
    public String toString() {
        return super.toString() + ", Customer Type: Gold" + " with goldLevel=" + goldLevel + "}";
    }
}
