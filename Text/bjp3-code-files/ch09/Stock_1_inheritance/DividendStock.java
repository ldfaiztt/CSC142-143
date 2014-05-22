// Represents a stock purchase that also pays dividends.
public class DividendStock extends Stock {
    private double dividends;   // amount of dividends paid

    // Constructs a new dividend stock with the given symbol
    // and no shares purchased.
    public DividendStock(String theSymbol) {
        super(theSymbol);  // call Stock constructor
        dividends = 0.0;
    }
    
    // Returns the total profit or loss earned on this stock,
    // including profits made from dividends.
    public double getProfit(double currentPrice) {
        return super.getProfit(currentPrice) + dividends;
    }

    // Records a dividend of the given amount per share.
    public void payDividend(double amountPerShare) {
        dividends += amountPerShare * getTotalShares();
    }
}
