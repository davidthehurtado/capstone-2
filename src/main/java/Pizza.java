import java.util.ArrayList;

public class Pizza {
    private final String size;
    private final String crust;
    private final boolean stuffedCrust;
    private final ArrayList<String> meats;
    private final ArrayList<String> cheeses;
    private final ArrayList<String> toppings;
    private final ArrayList<String> sauces;

    // Constructor sets the main pizza settings
    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;

        // to store customer choices
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    // Add-ons - ArrayList additions
    public void addMeat(String meat) { meats.add(meat); }
    public void addCheese(String cheese) { cheeses.add(cheese); }
    public void addTopping(String topping) { toppings.add(topping); }
    public void addSauce(String sauce) { sauces.add(sauce); }

    // getPrice() to determine the final cost
    public double getPrice() {
        double price = 0.0;

        // Base price by size
        if (size.equalsIgnoreCase("small")) price += Prices.SMALL_PIZZA;
        else if (size.equalsIgnoreCase("medium")) price += Prices.MEDIUM_PIZZA;
        else if (size.equalsIgnoreCase("large")) price += Prices.LARGE_PIZZA;

        // Extra charge for stuffed crust
        if (stuffedCrust) price += Prices.STUFFED_CRUST;

        // Count toppings based on how many were added
        price += meats.size() * Prices.MEAT_TOPPING;
        price += cheeses.size() * Prices.CHEESE_TOPPING;
        price += toppings.size() * Prices.VEGGIE_TOPPING;

        return price;
    }

    // Displays the pizza in a readable format
    public String toString() {
        return size + " " + crust + (stuffedCrust ? " (Stuffed Crust)" : "") +
                " | Meats: " + meats +
                " | Cheeses: " + cheeses +
                " | Toppings: " + toppings +
                " | Sauces: " + sauces +
                " | $" + String.format("%.2f", getPrice());
    }
}