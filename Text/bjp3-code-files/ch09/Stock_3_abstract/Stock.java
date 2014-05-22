// A Stock object represents purchases of shares of a stock.
public class Stock extends ShareAsset {
    private int totalShares;

    // Constructs a new Stock with the given symbol and
    // current price per share.
    public Stock(String symbol, double currentPrice) {
        super(symbol, currentPrice);
        totalShares = 0;
    }

    // Returns the market value of this stock, which is
    // the number of total shares times the share price.
    public double getMarketValue() {
        return totalShares * getCurrentPrice();
    }

    // Returns the total number of shares purchased.
    public int getTotalShares() {
        return totalShares;
    }

    // Records a purchase of the given number of shares of
    // stock at the given price per share.
    public void purchase(int shares, double pricePerShare) {
        totalShares += shares;
        addCost(shares * pricePerShare);
    }
}