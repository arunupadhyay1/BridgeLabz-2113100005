// Write a program to create a Book class with attributes title, author, and price. Add a method to display the book details.
public class book{ 
//made a public class called book
	private static String title;
	private static String author;
	private static double price;
public book(String title, String author, double price)	{
//made constructor with parameters title author price	
  this.title = title;
  this.author = author;
  this.price = price;
}
public void bookdetail(){
//made a method called bookdetail
	System.out.println("The Book detais are:");
    System.out.println("The Title of bookm is: " + title);
    System.out.println("The Author of bookm is: " + author);
    System.out.println("The Price of bookm is: " + price);
}
	public static void main(String[] args){
//made main method
	book book1 = new book("	Let us C","Arun",200);
		book1.bookdetail();
//called method bookdetail
	}
}