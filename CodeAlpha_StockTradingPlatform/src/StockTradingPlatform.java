import java.util.*;

class StockMarket {
    private final Map<String, Double> stockPrices = new HashMap<>();
    
    public StockMarket() {
        stockPrices.put("AAPL", 150.0);
        stockPrices.put("GOOGL", 2800.0);
        stockPrices.put("AMZN", 3400.0);
    }
