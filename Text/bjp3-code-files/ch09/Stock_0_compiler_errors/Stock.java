// A Stock object represents purchases of shares of a stock.
public class Stock {
    private String symbol;
    private int totalShares;
    private double totalCost;

    // Initializes a new Stock with no shares purchased.
    public Stock(String theSymbol) {
        symbol = theSymbol;
        totalShares = 0;
        totalCost = 0.0;
    }

    // Returns the total profit or loss earned on this stock.
    public double getProfit(double currentPrice) {
        double marketValue = totalShares * currentPrice;
        return marketValue - totalCost;
    }

    // Records purchase of the given shares at the given price.
    public void purchase(int shares, double pricePerShare) {
        totalShares += shares;
        totalCost += shares * pricePerShare;
    }
}
