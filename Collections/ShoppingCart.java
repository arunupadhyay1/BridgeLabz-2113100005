import java.util.*;

class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Apple", 0.99);
        productPrices.put("Banana", 0.59);
        productPrices.put("Orange", 0.79);

        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Apple", 2);
        cart.put("Banana", 3);
        cart.put("Orange", 1);

        displayCart(cart, productPrices);
    }

     public static void displayCart(Map<String, Integer> cart, Map<String, Double> productPrices) {
        System.out.println("Shopping Cart:");
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            double itemTotal = price * quantity;
            total += itemTotal;
            System.out.println(product + " x" + quantity + " = $" + itemTotal);
        }
        System.out.println("Total: $" + total);
    }
}
