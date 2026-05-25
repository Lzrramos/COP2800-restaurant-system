// Lazaro Ramos
// 05/03/2025

/* This class is an extension of the MenuItem class that is used to validate, 
   store and add a size to the drink item. */

public class DrinkItem extends MenuItem {

    /* Declares class name and sets the inherited fields and methods from MenuItem class. */

    private String size;

     /* Declares private string variable named size. To store the size of the drink. */

    public DrinkItem(String id, String name, String size) {

        /* Constructor called when create new drink item. */

        super(id, name);

        /* Calls parent class constructor and passes id and name to it. */

        if (size != null && (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L"))) {

             /* Verifies if the size is not null and is either "S", "M", or "L". ignoring the case. */

            this.size = size.toUpperCase();

            /* If the size is valid store it as an uppercase letter. */

        } else {
            this.size = "S";

            /* If the size is not valid default the size to S. */

        }
    }
    

    public String getSize() {

        /* Getter method used to call getSize method */

        return size;

        /* Return size of the drink. */

    }


    @Override
public String getDescription() {

    /* Overrrides the getDescription method from MenuItem class. */

    switch (size.toUpperCase()) {
        case "S": return "Size: Small";
        case "M": return "Size: Medium";
        case "L": return "Size: Large";
        default: return "Size: Unknown";

        /* Checks the value of size and returns the specified text. If its not s, m, or l it returns unknown. */

    }
}

    @Override
    public String toFileString() {

        /* Overrides the toFileString. */

        return "D," + getID() + "," + getName() + "," + getPrice() + "," + getQuantityAvailable() + "," + size;

       /* Returns a formatted text indicating the its a drink, id, name, price, quantity and size.*/

    }
}