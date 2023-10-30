





public class Stock {

    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

    }
    public double getChangePercent(){

        double change = (currentPrice - previousClosingPrice ) / (previousClosingPrice) ;
        change = change * 100;

        return change;

    }




}
