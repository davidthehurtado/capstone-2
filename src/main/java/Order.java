import java.util.ArrayList;

// Order class - Keeps track of everything in the order and calculates the total and generates the order summary used for receipt files.
public class Order {
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private int garlicKnotsQty;

    public void addPizza(Pizza p) { pizzas.add(p); }
    public void addDrink(Drink d) { drinks.add(d); }
    public void addGarlicKnots(int qty) { garlicKnotsQty += qty; }

    // calculateTotal() - Loops through all pizzas and drinks, adds garlic knots price, & returns final total.
    public double calculateTotal() {
        double total = 0.0;

        for (Pizza p : pizzas) total += p.getPrice();
        for (Drink d : drinks) total += d.getPrice();

        total += garlicKnotsQty * Prices.GARLIC_KNOT_PRICE;

        return total;
    }

    // toString() Creates the formatted text used for: viewing order on screen, saving order receipt to file
    public String toString() {
        String summary = "\n--- Order Summary ---\n";

        for (Pizza p : pizzas) summary += p + "\n";

        for (Drink d : drinks) summary += d + "\n";

        if (garlicKnotsQty > 0) {
            summary += garlicKnotsQty + " Garlic Knots - $" +
                    String.format("%.2f", garlicKnotsQty * Prices.GARLIC_KNOT_PRICE) + "\n";
        }

        summary += "----------------------\nTotal: $" +
                String.format("%.2f", calculateTotal()) + "\n";

        return summary;
    }
}