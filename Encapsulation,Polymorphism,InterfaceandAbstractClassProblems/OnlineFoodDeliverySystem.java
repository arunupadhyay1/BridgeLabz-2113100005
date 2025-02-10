public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Vegetable Pizza", 10, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Burger", 8, 1);

        System.out.println(vegItem.getItemDetails());
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());
        System.out.println(((Discountable) vegItem).getDiscountDetails());

        System.out.println(nonVegItem.getItemDetails());
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
        System.out.println(((Discountable) nonVegItem).getDiscountDetails());
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    protected double getPrice() { // Protected getter for price
        return price;
    }

    protected int getQuantity() { // Protected getter for quantity
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item Name: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Subclass for Vegetarian Items
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // Total price for vegetarian items
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1; // 10% discount
    }

    public String getDiscountDetails() {
        return "Discount: " + applyDiscount();
    }
}

// Subclass for Non-Vegetarian Items
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 5; // Additional charge for non-veg items
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    public String getDiscountDetails() {
        return "Discount: " + applyDiscount();
    }
}