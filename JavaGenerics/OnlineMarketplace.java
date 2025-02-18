public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", new BookCategory(), 50.0);
        Marketplace marketplace = new Marketplace();
        marketplace.applyDiscount(book, 10);
        System.out.println("Discounted Price: " + book.price);
    }
}
class Product<T> {
    String name;
    T category;
    double price;

    public Product(String name, T category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

class BookCategory {}
class ClothingCategory {}

class Marketplace {
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }
}

