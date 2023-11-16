package BASIC;




class Gold extends Customer{

    private int goldLevel;

    public Gold(int ID, String prferredPaymentMethod, int goldLevel) {
        super(ID, prferredPaymentMethod);
        this.goldLevel = goldLevel;
    }

    public int getGoldLevel() {
        return goldLevel;
    }

    public void setGoldLevel(int goldLevel) {
        this.goldLevel = goldLevel;
    }

    @Override
    double discountPercentage() {
        return 0;
    }

}
