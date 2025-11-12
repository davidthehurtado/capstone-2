public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        if (size.equalsIgnoreCase("small")) return Prices.SMALL_DRINK;
        else if (size.equalsIgnoreCase("medium")) return Prices.MEDIUM_DRINK;
        else return Prices.LARGE_DRINK;
    }

    public String toString() {
        return size + " " + flavor + " Drink - $" + String.format("%.2f", getPrice());
    }
}