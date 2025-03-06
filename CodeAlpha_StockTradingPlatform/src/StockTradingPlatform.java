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

class Portfolio {
    private final Map<String, Integer> holdings = new HashMap<>();
    private double balance = 10000.0;
    
    public void buyStock(String symbol, int quantity, double price) {
        if (price == 0.0) {
            System.out.println("Invalid stock symbol.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        
        double cost = quantity * price;
        System.out.println("Attempting to buy " + quantity + " shares of " + symbol + " at $" + price + " each.");
        System.out.println("Total cost: $" + cost);
        System.out.println("Current balance: $" + balance);
        
        if (cost <= balance) {
            holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
            balance -= cost;
            System.out.println("Bought " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Insufficient balance.");
        }
        showPortfolio();
    }
    
    public void sellStock(String symbol, int quantity, double price) {
        if (price == 0.0) {
            System.out.println("Invalid stock symbol.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        
        int availableShares = holdings.getOrDefault(symbol, 0);
        if (availableShares >= quantity) {
            holdings.put(symbol, availableShares - quantity);
            balance += quantity * price;
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Not enough shares to sell.");
        }
        showPortfolio();
    }
