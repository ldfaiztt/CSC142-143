public class AssetExample {
    public static void main(String[] args) {
        Asset[] investments = new Asset[4];
        investments[0] = new Stock("MSFT", 10, 300.00, 27.50);
        investments[1] = new Cash(500.00);
        investments[2] = new Cash(1200.54);
        investments[3] = new Stock("INTC", 30, 620.00, 23.00);

        for (int i = 0; i < investments.length; i++) {
            System.out.println(investments[i]);
            System.out.println("Market value is: " + 
                    investments[i].getMarketValue() + 
                    ", profit is: " +
                    investments[i].getProfit());
            System.out.println();
        }
    }
}
