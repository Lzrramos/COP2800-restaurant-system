// Lazaro Ramos
// 05/03/2025


import java.io.*;
import java.util.Scanner;

/* Imports java classes and scanner. */

public class RestaurantApp {

    /* Declares class name and holds main method of program. */

    public static void main(String[] args) {

        /* Declares the entry point of the program. */

        Scanner input = new Scanner(System.in);

        /* Creates the scanner. */

        RestaurantInventory inventory = new RestaurantInventory();

        /* Creates empty object to store items. */

        loadInventory("restaurantInventory.csv", inventory);

        /* Loads inventory from csv. */

        int choice;

        /* Creates variable to store number for menu choice. */

        do {

            /* Starts do-while loop. */

            choice = displayMenu(input);

            /* Calls displayMenu method to store users menu choice. */

            processChoice(input, choice, inventory);

            /* processChoice method used to process the users input and call the correct method. */

        } while (choice != 99);

        /* Loop continues until user inputs 99 */

    }

    public static int displayMenu(Scanner input) {

        /* Declares method used to display menu. */

        System.out.println("\nMenu:");
        System.out.println("1) List all menu items");
        System.out.println("2) Find a menu item");
        System.out.println("3) Add a menu item");
        System.out.println("4) Remove a menu item");
        System.out.println("5) Save menu items");
        System.out.println("99) Quit");
        System.out.print("Please enter your choice: ");

        /* Dislays menu with each option. */

        String scanner = input.nextLine();

        /* Reads input and stores it in input variable. */

        try {
            return Integer.parseInt(scanner);

            /* Converts user input to an integer. */

        } catch (NumberFormatException e) {

            /* Catches errors in case something other than a number is input. */

            return -1;

            /* If true it returns -1. */
            
        }
    }

    public static void processChoice(Scanner scanner, int choice, RestaurantInventory inventory) {

        /* Declares a method to process user choice. */

        switch (choice) {

            /* Handles the users input to call the correct option. */

            case 1:
                listAllItems(inventory);
                break;
            case 2:
                findMenuItem(scanner, inventory);
                break;
            case 3:
                addMenuItem(scanner, inventory);
                break;
            case 4:
                removeMenuItem(scanner, inventory);
                break;
            case 5:
                saveInventory("restaurantInventory.csv", inventory);
                break;
            case 99:
                System.out.println("Bye!");
                break;

                /* Each option tells the program what to do for each. */

            default:
                System.out.println("Error! Invalid choice.");

                /* If user inputs an invalid number an error message is diaplayed. */

        }
    }

    public static void listAllItems(RestaurantInventory inventory) {

        /* Declares method to list all items.  */

        for (MenuItem item : inventory.getAllItems()) {

            /* Gets list of all menu items */

            displayItemData(item);

            /* Loops through each item and calls displayItemData to show its details. */

            System.out.println("********************************");

            /* Prints line of asterisks to seperate each. */

        }
    }

    public static void findMenuItem(Scanner input, RestaurantInventory inventory) {

        /* Declares method used to find menu items. */

        System.out.print("Please enter item ID to search: ");

        /* Asks user to enter item id. */

        String id = input.nextLine();

        /* Reads input and stores it in id variable */

        MenuItem item = inventory.getItemByID(id);

        /* Searches for menu item by id */

        if (item != null) {

            /* If item is not equal to null its true. */

            displayItemData(item);

            /* If true program returns the item. */

        } else {
            System.out.println("Error! Item not found.");

            /* If false error message is displayed */

        }
    }

    public static void addMenuItem(Scanner scanner, RestaurantInventory inventory) {

        /* Declares method used to add menu item. */

        System.out.print("Please enter item type (F for Food, D for Drink): ");

        /* Asks user to enter item type. */

        String type = scanner.nextLine().toUpperCase();

        /* Reads input and stores it in type variable. */

        System.out.print("Please enter item ID: ");

        /* Asks user for item id. */

        String id = scanner.nextLine();

        /* Reads input and stores in id variable. */

        System.out.print("Please enter item name: ");

        /* Asks user for item name. */

        String name = scanner.nextLine();

        /* reads input and stores in name variable. */

        MenuItem item = null;

        /* Declaring item variable set at null. */

        if (type.equals("F")) {

            /* Cheking if type variable is equal to f.*/

            System.out.print("Enter food category: ");

            /* Asks user to input food category. */

            String category = scanner.nextLine();

            /* Reads input data and stores it in category variable. */

            item = new FoodItem(id, name, category);

            /* Creates new food item object and stores it in item variable. */

        } else if (type.equals("D")) {

            /* Checks if type is equal to d. */

            System.out.print("Enter drink size (S, M, L): ");

            /* Asks user for drink size */

            String size = scanner.nextLine();

            /* Reads input and stores it in size variable. */

            item = new DrinkItem(id, name, size);

            /* Creates new drink item object and stores it in item variable. */

        } else {
            System.out.println("Invalid type.");
            return;

            /* If its not d or f it prints out error message. */

        }

        item.setPrice(promptDouble(scanner, "Please enter price: "));

        /* Set price of the item by asking user for price and storing result. */

        item.setQuantity(promptInt(scanner, "Please enter quantity: "));

        /* Set quantity of the item by asking user for quantity and storing result. */

        if (inventory.addMenuItem(item)) {

            /* Checks if item was added. */

            System.out.println("Item was added successfully.");

            /* If item was added returns success . */

        } else {
            System.out.println("Error! Failed to add item.");

            /* If item was not added returns error message. */

        }
    }

    public static void removeMenuItem(Scanner scanner, RestaurantInventory inventory) {

        /* Declares method to remove item. */

        System.out.print("Please enter item ID to remove: ");

        /* Asks user for item id. */

        String id = scanner.nextLine();

        /* Reads input an stores in id variable. */

        MenuItem removed = inventory.removeItemByID(id);

        /* Declares method to find item by id, remove it, return removed item, or null if not found. */

        if (removed != null) {

            /* If variable is not equal to null item was found. */

            System.out.println("Item was removed successfully.");

            /* If item was found delete item and print success message */

        } else {
            System.out.println("Error! Item was not found.");

            /* If item was not found return error message. */

        }
    }

    public static void displayItemData(MenuItem item) {

        /* Declare method used to display item data. */

        System.out.println("Item ID: " + item.getID());
        System.out.println("Item name: " + item.getName());
        System.out.printf("Price: $%.2f%n", item.getPrice());
        System.out.println("Quantity: " + item.getQuantityAvailable());
        System.out.println(item.getDescription());

        /* Prints out item data. */

    }

    public static void loadInventory(String filename, RestaurantInventory inventory) {

        /* Declare method used to read items and adds them into inventory. */

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            /* Try with resources block. used to read file data. */

            String line;

            /* Creating variable to store text. */

            while ((line = reader.readLine()) != null) {

                /* Loops through each item until reaches end of the file. */

                String[] tokens = line.split(",");

                /* Declares string array stores data seperated by commas. */

                if (tokens.length < 6) continue;

                /* Checks how many pieces were created. checking if incomplete. */

                String type = tokens[0];
                String id = tokens[1];
                String name = tokens[2];
                double price = Double.parseDouble(tokens[3]);
                int quantity = Integer.parseInt(tokens[4]);

                /* Extracts and converts data per variable */

                MenuItem item = null;

               /* Declaring item variable set at null. */

                if (type.equals("F")) {

                    /* Checking if type equals f. */

                    String category = tokens[5];

                    /* Assigns the value of token 5 to category variable. */

                    item = new FoodItem(id, name, category);

                    /* Creates new food item object. */

                } else if (type.equals("D")) {

                    /* Checks if type equals d. */

                    String size = tokens[5];

                    /* Assigns token 5 to size variable. */

                    item = new DrinkItem(id, name, size);

                    /* Creates new drink item object. */

                }

                if (item != null) {

                    /* Verifies item is not equal to null */

                    item.setPrice(price);
                    item.setQuantity(quantity);
                    inventory.addMenuItem(item);

                    /* If true it sets the above variables. */

                }
            }
        } catch (IOException e) {

            /* Checks for errors. */

            System.out.println("Error loading inventory: " + e.getMessage());

            /* If false it returns an error message. */

        }
    }

    public static void saveInventory(String filename, RestaurantInventory inventory) {

        /* Declares method used to save inventory. */

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {

            /* Declares try with resources block. */

            for (MenuItem item : inventory.getAllItems()) {

                /* Begins for- each loop to loop through each menu item. */

                writer.println(item.toFileString());

                /* Writes each menu item to the inventory file. */

            }
            System.out.println("Inventory was saved successfully.");

            /* If successful prints out success message. */

        } catch (IOException e) {

            /* Checks for errors. */

            System.out.println("Error saving inventory: " + e.getMessage());

            /* If it wasnt successful it returns error message. */

        }
    }

    private static double promptDouble(Scanner scanner, String message) {

        /* Declares a method used to prompt user for a double value. */

        System.out.print(message);

        /* Prints message asking for double. */

        while (true) {

            /* Begins loop for try-catch block. */

            try {
                return Double.parseDouble(scanner.nextLine());

                /* Reads input and converts it to double. */

            } catch (NumberFormatException e) {

                /* Checks for errors. */

                System.out.print("Error! Invalid input. " + message);

                /* If input is invalid print error message. */

            }
        }
    }

    private static int promptInt(Scanner scanner, String message) {

        /* Declares a method used to prompt user for an integer. */

        System.out.print(message);

         /* Prints message asking for integer. */


        while (true) {

             /* Begins loop for try-catch block. */

            try {
                return Integer.parseInt(scanner.nextLine());

                /* Reads input and converts it to an integer. */

            } catch (NumberFormatException e) {

                /* Checks for errors. */

                System.out.print("Error! Invalid input. " + message);

                /* If input is invalid print error message. */

            }
        }
    }
}