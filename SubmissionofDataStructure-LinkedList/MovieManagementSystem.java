public class MovieManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();
        
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtBeginning("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        
        System.out.println("Movies in forward order:");
        movieList.displayForward();
        
        System.out.println("\nMovies in reverse order:");
        movieList.displayReverse();
        
        System.out.println("\nSearch by Director (Christopher Nolan):");
        movieList.searchByDirector("Christopher Nolan");
        
        System.out.println("\nSearch by Rating (9.0):");
        movieList.searchByRating(9.0);
        
        System.out.println("\nUpdating rating for 'Inception' to 9.0");
        movieList.updateRating("Inception", 9.0);
        
        System.out.println("\nMovies after update:");
        movieList.displayForward();
        
        System.out.println("\nRemoving 'The Godfather'");
        movieList.removeByTitle("The Godfather");
        
        System.out.println("\nMovies after removal:");
        movieList.displayForward();
    }
}class Node {
    String title;
    String director;
    int year;
    double rating;
    Node next;
    Node prev;

    public Node(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList {
    Node head;
    Node tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        Node newNode = new Node(title, director, year, rating);
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
        } else if (position == size()) {
            addAtEnd(title, director, year, rating);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }
    public void removeByTitle(String title) {
        if (head == null) {
            return;
        }
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.title.equals(title)) {
                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.next.prev = temp;
                } else {
                    tail = temp;
                }
                return;
            }
            temp = temp.next;
        }
    }
    public void searchByDirector(String director) {
        Node temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }
    public void searchByRating(double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }
    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
    public void updateRating(String title, double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
