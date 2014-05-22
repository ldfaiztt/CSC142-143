// Represents a mutual fund asset.
public class MutualFund extends ShareAsset {
    private double totalShares;
    
    // Constructs a new MutualFund investment with the given
    // symbol and price per share.
    public MutualFund(String symbol, double currentPrice) {
        super(symbol, currentPrice);
        totalShares = 0.0;
    }
    
    // Returns the market value of this mutual fund, which
    // is the number of shares times the price per share.
    public double getMarketValue() {
        return totalShares * getCurrentPrice();
    }
    
    // Returns the number of shares of this mutual fund.
    public double getTotalShares() {
        return totalShares;
    }
    
    // Records purchase of the given shares at the given price.
    public void purchase(double shares, double pricePerShare) {
        totalShares += shares;
        addCost(shares * pricePerShare);
    }
}
