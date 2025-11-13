// Stores size & flavor. Price depends only on size.
public class Drink {
    private String size;
    private String flavor;

    // Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Price calculation
    public double getPrice() {
        if (size.equalsIgnoreCase("small")) return Prices.SMALL_DRINK;
        else if (size.equalsIgnoreCase("medium")) return Prices.MEDIUM_DRINK;
        else return Prices.LARGE_DRINK;
    }

    // Display drink info
    public String toString() {
        return size + " " + flavor + " Drink - $" +
                String.format("%.2f", getPrice());
    }
}