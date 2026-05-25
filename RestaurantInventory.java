// Lazaro Ramos
// 05/03/2025

/* This class is used to contain and manage all items in the menu. */

import java.util.ArrayList;

/* Imports javas ArrayList class. */

public class RestaurantInventory {

    /* Declares class name and begins the class. */

    private ArrayList<MenuItem> menuItems;

    /* Creates private list to hold menu items. */

    public RestaurantInventory() {

        /* Constructor that runs when a new inventory object is created. */

        menuItems = new ArrayList<>();

        /* Begins the list so it starts empty. */

    }

    public int getNumberOfItems() {

        /* Declares a method used to get the number of items.  */

        return menuItems.size();

        /* Returns number of items currently in the list. */

    }

    public boolean addMenuItem(MenuItem item) {

        /* Declares a method used to add an item to the menu. */

        if (item == null || findPosition(item.getID()) != -1) {

            /* Verifies if the item is null or theres an item with the same id */

            return false;

            /* If the above is true it returns false. */

        }
        menuItems.add(item);
        return true;

        /* If the above is false it returns true and adds the item to the menu. */

    }

    public int findPosition(String id) {

        /* Declares a method used to find an items position on the list. */

        for (int i = 0; i < menuItems.size(); i++) {

            /* Loops through all of the items checking one at a time starting at 0 */

            if (menuItems.get(i).getID().equalsIgnoreCase(id)) {

                /* Checks if the item matches the one im looking for */

                return i;

                /* returns the item once its found. */

            }
        }
        return -1;

        /* If its not found it returns -1 */

    }

    public MenuItem getItemByID(String id) {

        /* Declares a method used to find an item by its id. */

        int pos = findPosition(id);

        /* Creates new variable that will hold an integer. Calls findPosition method to get id */

        if (pos != -1) {
            return menuItems.get(pos);

            /* If pos is not equal -1 return the menu item. */

        }
        return null;

        /* If pos is equal to -1 return null. */

    }

    public MenuItem getItemByIndex(int index) {

        /* Declares method to get item by position on the list. */

        if (index >= 0 && index < menuItems.size()) {

            /* Checks if the index is greater than 0 and less than the number of items in the list. */

            return menuItems.get(index);

            /* If true it returns the item at that index. */

        }
        return null;

        /* If false it returns null. */

    }

    public MenuItem removeItemByID(String id) {

        /* Declares method to remove item by id. */

        int pos = findPosition(id);

        /* Creates new variable that will hold an integer. Calls findPosition method to get id */

        if (pos != -1) {

            /* If pos is not equal to -1 its true. */

            return menuItems.remove(pos);

            /* If true it removes the item. */

        }
        return null;

        /* If false it returns null. */

    }

    public ArrayList<MenuItem> getAllItems() {

        /* Declares method used to get all items in the list. */

        return new ArrayList<>(menuItems); 

        /* Returns all items in the list. */
    }
}