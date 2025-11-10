import java.util.ArrayList;


public class Pizza {
    private String size;
    private String crust;
    private boolean stuffedCrust;
    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;


    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }


    public void addMeat(String meat) { meats.add(meat); }
    public void addCheese(String cheese) { cheeses.add(cheese); }
    public void addTopping(String topping) { toppings.add(topping); }
    public void addSauce(String sauce) { sauces.add(sauce); }


    public double getPrice() {
        double price = 0.0;
        if (size.equalsIgnoreCase("small")) price += PriceConstants.SMALL_PIZZA;
        else if (size.equalsIgnoreCase("medium")) price += PriceConstants.MEDIUM_PIZZA;
        else if (size.equalsIgnoreCase("large")) price += PriceConstants.LARGE_PIZZA;


        if (stuffedCrust) price += PriceConstants.STUFFED_CRUST;


        price += meats.size() * PriceConstants.MEAT_TOPPING;
        price += cheeses.size() * PriceConstants.CHEESE_TOPPING;
        price += toppings.size() * PriceConstants.VEGGIE_TOPPING;


        return price;
    }


    public String toString() {
        return size + " " + crust + (stuffedCrust ? " (Stuffed Crust)" : "") +
                " | Meats: " + meats +
                " | Cheeses: " + cheeses +
                " | Toppings: " + toppings +
                " | Sauces: " + sauces +
                " | $" + String.format("%.2f", getPrice());
    }
}
