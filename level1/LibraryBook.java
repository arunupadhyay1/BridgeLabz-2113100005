public class LibraryBook {
    String title;
    String  author;
    float price;
    boolean availability;

    LibraryBook(){
        title="";
        author="";
        price=0.0f;
        availability=true;
    }
    LibraryBook(String title, String author,float price , boolean availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=availability;
    }

    void borrowBook(){
        if(!availability){
            System.out.println("Book is not available");
            return ;
        }
        System.out.println("Book issued");
        availability=false;
    }

    public static void main(String[] args) {
        LibraryBook ob =new LibraryBook("The Titans","Thomas",76.4f,true);
        ob.borrowBook();
        ob.borrowBook();

    }
}