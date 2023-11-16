package BASIC;


import java.util.Date;

abstract class Customer extends User {
    private String prferredPaymentMethod;


    public Customer(int ID, String prferredPaymentMethod) {
        super(ID);
        this.prferredPaymentMethod = prferredPaymentMethod;
    }



    public String getPrferredPaymentMethod() {
        return prferredPaymentMethod;
    }

    public void setPrferredPaymentMethod(String prferredPaymentMethod) {
        this.prferredPaymentMethod = prferredPaymentMethod;
    }

    abstract double discountPercentage();

}
