public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "001", true);
		library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", "002", true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", "003", true);
        library.addBookAtBeginning("Moby Dick", "Herman Melville", "Fiction", "004", true);
        
        System.out.println("Books in the library (forward order):");
        library.displayBooksForward();

        System.out.println("\nTotal number of books: " + library.countTotalBooks());

        library.updateBookAvailability("001", false);
        System.out.println("\nAfter updating availability of 'The Great Gatsby':");
        library.displayBooksForward();

        library.removeBookById("002");
        System.out.println("\nAfter removing 'To Kill a Mockingbird':");
        library.displayBooksForward();

        Book searchedBook = library.searchBook("1984");
        if (searchedBook != null) {
            System.out.println("\nSearched Book: " + searchedBook.title + " by " + searchedBook.author);
        } else {
            System.out.println("\nBook not found.");
        }

        System.out.println("\nBooks in the library (reverse order):");
        library.displayBooksReverse();
    }
}
class Book {
    String title;
    String author;
    String genre;
    String bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, String bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;
    private Book tail;

    public void addBookAtBeginning(String title, String author, String genre, String bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addBookAtEnd(String title, String author, String genre, String bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addBookAtPosition(String title, String author, String genre, String bookId, boolean isAvailable, int position) {
        if (position == 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;
        }
        current.next = newBook;
    }

    public void removeBookById(String bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }

    public Book searchBook(String searchTerm) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(searchTerm) || current.author.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateBookAvailability(String bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found");
    }

    public void displayBooksForward() {
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookId + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public int countTotalBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
