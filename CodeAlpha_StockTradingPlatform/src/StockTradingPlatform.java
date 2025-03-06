import java.util.*;

class StockMarket {
    private final Map<String, Double> stockPrices = new HashMap<>();
    
    public StockMarket() {
        stockPrices.put("AAPL", 150.0);
        stockPrices.put("GOOGL", 2800.0);
        stockPrices.put("AMZN", 3400.0);
    }
    
    public double getPrice(String symbol) {
        return stockPrices.getOrDefault(symbol, 0.0);
    }
    
    public void showMarketData() {
        System.out.println("Stock Market Data:");
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
            System.out.println(entry.getKey() + " : $" + entry.getValue());
        }
    }
}
