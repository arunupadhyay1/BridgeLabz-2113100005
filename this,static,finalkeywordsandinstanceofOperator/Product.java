/*Sample Program 4: Shopping Cart System
Create a Product class to manage shopping cart items with the following features:
Static:
A static variable discount shared by all products.
A static method updateDiscount() to modify the discount percentage.
This:
Use this to initialize productName, price, and quantity in the constructor.
Final:
Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
Instanceof:
Validate whether an object is an instance of the Product class before processing its details.
*/

public class Product{
	private static double discount = 0;
	private String productName;
	private final String productID;
	private double price;
	private int quantity;
	public Product(String productName,	String productID,double price,int quantity){
			this.productName = productName;
			this.productID = productID;
			this.price = price;
			this.quantity = quantity;
	}
	public static void UpdateDiscount(double newDiscount){
		discount = newDiscount;  
	}
	public void displayProductDetails(){
		if(this instanceof Product){
			double discountedPrice = price-(price*discount/100);
			System.out.println("Product Name: "+productName);
		    System.out.println("Product ID: "+productID);
			System.out.println("Price: "+ price);
			System.out.println("Quantity: "+ quantity);
			System.out.println("Discounted Price: "+ discountedPrice);
		}
	}
	public static void main(String[]args){
		Product.UpdateDiscount(5.0);//update discount to 5
		Product product1 = new Product("Smartwatch", "0111", 2000, 2);
		Product product2 = new Product("Aquarium", "0101", 950, 3);
		Product product3 = new Product("SmartPhone", "0110", 20000, 4);
		product1.displayProductDetails();
		product2.displayProductDetails();
		product3.displayProductDetails();
		}
}