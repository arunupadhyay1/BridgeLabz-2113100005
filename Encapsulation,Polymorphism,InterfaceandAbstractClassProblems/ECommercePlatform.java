public class ECommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Electronics(1, "Laptop", 1000);
        Product product2 = new Clothing(2, "T-Shirt", 50);

        System.out.println("Final Price of Laptop: " + product1.finalPrice());
        System.out.println("Final Price of T-Shirt: " + product2.finalPrice());
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price; // Added getPrice method
    }

    public abstract double calculateDiscount();

    public double finalPrice() {
        // Cast to Taxable to call calculateTax
        if (this instanceof Taxable) {
            Taxable taxableProduct = (Taxable) this;
            return price + taxableProduct.calculateTax() - calculateDiscount();
        }
        return price - calculateDiscount(); // No tax if not taxable
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }

    public String getTaxDetails() {
        return "Tax: " + calculateTax();
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    public String getTaxDetails() {
        return "Tax: " + calculateTax();
    }
}