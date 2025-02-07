public class LibraryTest {
    public static void main(String[] args) {
        Author author = new Author();
        author.title = "Java Programming";
        author.publicationYear = 2023;
        author.name = "John Doe";
        author.bio = "Expert in Java";
        author.displayInfo();
    }
}
class Book {
    String title;
    int publicationYear;

    void displayInfo() {
        System.out.println("Title: " + title + ", Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name + ", Bio: " + bio);
    }
}


