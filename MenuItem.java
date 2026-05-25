// MenuItem.java
public abstract class MenuItem {
    private String id;
    private String name;
    private double price;
    private int quantityAvailable;
    private boolean validItem;

    public MenuItem(String id, String name) {
        validItem = true;
        if(id == null || id.isEmpty())
        {
            id = "**";
            validItem = false;
        }
        if(name == null || name.isEmpty())
        {
            name = "**";
            validItem = false;
        }
        this.id = id;
        this.name = name;
        this.price = 0.0;  // Default price
        this.quantityAvailable = 0;  // Default quantity
    }

    public String getID() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantityAvailable() { return quantityAvailable; }
    public boolean isValidItem(){ return validItem; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantityAvailable = quantity; }

    public abstract String getDescription();
    public abstract String toFileString();

    @Override
    public String toString() {
        return id + " - " + name + " - Price: $" + price + ", Quantity: " + quantityAvailable + ", " + getDescription();
    }
}
