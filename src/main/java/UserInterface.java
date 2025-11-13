import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder = new Order();

    public void displayHome() {
        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println(" Welcome to THE YEAST WE CAN DO!");
            System.out.println("==============================");
            System.out.println("1 - Add Pizza");
            System.out.println("2 - Add Drink");
            System.out.println("3 - Add Garlic Knots");
            System.out.println("4 - View Order");
            System.out.println("5 - Checkout");
            System.out.println("6 - Start New Order");
            System.out.println("99 - Quit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) processAddPizza();
            else if (choice.equals("2")) processAddDrink();
            else if (choice.equals("3")) processAddGarlicKnots();
            else if (choice.equals("4")) System.out.println(currentOrder);
            else if (choice.equals("5")) processCheckout();
            else if (choice.equals("6")) newOrder();
            else if (choice.equals("99")) {
                System.out.println("Thank you for visiting THE YEAST WE CAN DO!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ADD PIZZA
    private void processAddPizza() {
        System.out.println("\n--- Add a Pizza ---");

        System.out.print("Size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        System.out.print("Crust type: ");
        String crust = scanner.nextLine();

        System.out.print("Stuffed crust? (Y/N): ");
        boolean stuffed = scanner.nextLine().equalsIgnoreCase("Y");

        Pizza pizza = new Pizza(size, crust, stuffed);

        System.out.print("Add a meat topping? (Type name or leave blank): ");
        String meat = scanner.nextLine();
        if (!meat.isEmpty()) pizza.addMeat(meat);

        System.out.print("Add a cheese topping? (Type name or leave blank): ");
        String cheese = scanner.nextLine();
        if (!cheese.isEmpty()) pizza.addCheese(cheese);

        System.out.print("Add a veggie topping? (Type name or leave blank): ");
        String topping = scanner.nextLine();
        if (!topping.isEmpty()) pizza.addTopping(topping);

        System.out.print("Add a sauce? (Type name or leave blank): ");
        String sauce = scanner.nextLine();
        if (!sauce.isEmpty()) pizza.addSauce(sauce);

        currentOrder.addPizza(pizza);
        System.out.println("Pizza added! " + pizza);
    }

    // ADD DRINK
    private void processAddDrink() {
        System.out.println("\n--- Add a Drink ---");

        System.out.print("Drink size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        System.out.print("Flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        System.out.println("Drink added: " + drink);
    }

    // ADD GARLIC KNOTS
    private void processAddGarlicKnots() {
        System.out.print("\nEnter quantity of Garlic Knots: ");

        try {
            int qty = Integer.parseInt(scanner.nextLine());
            currentOrder.addGarlicKnots(qty);
            System.out.println(qty + " garlic knots added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        }
    }

    // CHECKOUT

    private void processCheckout() {
        System.out.println("\n--- Checkout ---");
        System.out.println(currentOrder);

        saveReceipt();   // Save ONE receipt per order
        newOrder();      // Reset for next customer
    }

    // SAVE RECEIPT TO /receipts FOLDER

    private void saveReceipt() {
        // Create receipts folder if needed
        java.io.File folder = new java.io.File("receipts");
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Create filename using date/time
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String fileName = "receipts/" + now.format(formatter) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(currentOrder.toString());
            System.out.println("Receipt saved successfully to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    // RESET ORDER
    private void newOrder() {
        currentOrder = new Order();
        System.out.println("New order started!");
    }
}