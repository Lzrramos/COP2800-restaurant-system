// Lazaro Ramos
// 05/03/2025

/* This class is an extension of the MenuItem class that is used to validate, 
   store and add a category to the food item. */

public class FoodItem extends MenuItem {

   /* Declares class name and sets the inherited fields and methods from MenuItem class. */

    private String category;

    /* Declares private string variable named category. To store the type of food. */

    public FoodItem(String id, String name, String category) {

        /* Constructor called when create new food item. */

        super(id, name);

        /* Calls parent class constructor and passes id and name to it. */

        if (category != null && !category.trim().isEmpty()) {

            /* Verifies if the category is not null and not empty spaces */

            this.category = category;

            /* If it comes back true it saves the food items category. */

        } else {
            this.category = "Unknown";

            /* If it comes back false it sets the category to unknown. */

        }
    }

    public String getCategory() {

        /* Getter method used to get the category. */

        return category;

        /* Returns the category variable. */

    }

    @Override
    public String getDescription() {

        /* Overrides the getDescription method. */

        return "Category: " + category;

        /* Return string that tells you what the category of the food is. */

    }

    @Override
    public String toFileString() {

        /* Overrides the toFileString method. */
        
        return "F," + getID() + "," + getName() + "," + getPrice() + "," + getQuantityAvailable() + "," + category;

        /* Returns a formatted text indicating its food the category, id, name, price and quantity.*/

    }
}