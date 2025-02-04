public class Book{
	private static String LibraryName = "My Library";
	private final String isbn;
	private String title;
	private String author;
	//Constructor to initialize title author isbn
	public Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	public static void displayLibraryName(){
		System.out.println("Library Name: "+ LibraryName );
	}
	public void displaybookdetails(){
		if (this instanceof Book){
		System.out.println("title: "+ title );
		System.out.println("author: "+ author );
		System.out.println("isbn: "+ isbn );
	}
    }
	public static void main(String[] args){
		Book book1 = new Book("Pride and Prejudice", "Jane Austen", "25131001");
		Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "25131002");
		Book book3 = new Book("Moby Dick", "Herman Melville", "25131003");
		Book book4 = new Book("The Catcher in the Rye", "J.D. Sakinger", "25131004");
		Book.displayLibraryName();
        book1.displaybookdetails();
        book2.displaybookdetails();		
        book3.displaybookdetails();		
        book4.displaybookdetails();		
		
	}
}