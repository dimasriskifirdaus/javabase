import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Menu> foodMenu = new ArrayList<>();
    private static ArrayList<Menu> drinkMenu = new ArrayList<>();
    private static double totalCost = 0;

    // MySQL connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    private static final String DB_USER = "root"; // Change this to your MySQL username
    private static final String DB_PASSWORD = ""; // Change this to your MySQL password

    // Method to connect to the database and load menu items
    private static void loadMenuFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM Menu";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");

                Menu menuItem = new Menu(name, category, price);

                // Categorize the menu items as food or drink
                if (category.equalsIgnoreCase("Food")) {
                    foodMenu.add(menuItem);
                } else if (category.equalsIgnoreCase("Drink")) {
                    drinkMenu.add(menuItem);
                }
            }
            System.out.println("Menu loaded from database successfully.");
        } catch (Exception e) {
            System.out.println("Error loading menu from database: " + e.getMessage());
        }
    }

    // Method to display the menu grouped by category
    private static void displayMenu() {
        System.out.println("Food Menu:");
        for (Menu item : foodMenu) {
            System.out.println(item);
        }

        System.out.println("\nDrink Menu:");
        for (Menu item : drinkMenu) {
            System.out.println(item);
        }
    }

    // Method to receive and process order (no loops)
    private static void processOrder(int foodIndex, int drinkIndex) {
        if (foodIndex >= 0 && foodIndex < foodMenu.size()) {
            System.out.println("You ordered: " + foodMenu.get(foodIndex).getName());
            totalCost += foodMenu.get(foodIndex).getPrice();
        } else {
            System.out.println("Invalid food choice.");
        }

        if (drinkIndex >= 0 && drinkIndex < drinkMenu.size()) {
            System.out.println("You ordered: " + drinkMenu.get(drinkIndex).getName());
            totalCost += drinkMenu.get(drinkIndex).getPrice();
        } else {
            System.out.println("Invalid drink choice.");
        }
    }

    // Method to print the receipt
    private static void printReceipt() {
        System.out.println("\n--- Receipt ---");
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Thank you for your order!");
    }

    public static void main(String[] args) {
        // Load menu from the database
        loadMenuFromDatabase();

        // Display the menu
        displayMenu();

        Scanner scanner = new Scanner(System.in);

        // Prompt user to select items without using loops
        System.out.println("\nEnter the index of the food item you want to order (0-" + (foodMenu.size() - 1) + "):");
        int foodIndex = scanner.nextInt();

        System.out.println("Enter the index of the drink item you want to order (0-" + (drinkMenu.size() - 1) + "):");
        int drinkIndex = scanner.nextInt();

        // Process the order
        processOrder(foodIndex, drinkIndex);

        // Print the receipt
        printReceipt();

        scanner.close();
    }
}
