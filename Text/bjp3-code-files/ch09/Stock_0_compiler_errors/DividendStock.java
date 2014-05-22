// Represents a stock purchase that also pays dividends.
public class DividendStock extends Stock {
    private double dividends;   // amount of dividends paid

    // Constructs a new dividend stock with the given symbol
    // and no shares purchased.
    public DividendStock(String theSymbol) {
        // This constructor does not compile!
        symbol = theSymbol;
        numShares = 0;
        totalCost = 0.0;
        dividends = 0.0;  // this is the new code
    }

    public double getProfit(double currentPrice) {
        return super.getProfit(currentPrice) + this.dividends;
    }

    // Records a dividend of the given amount per share.
    public void payDividend(double amountPerShare) {
        this.dividends += amountPerShare * this.getNumShares();
    }
}