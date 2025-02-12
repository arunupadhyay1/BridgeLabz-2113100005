public class TicketReservationSystem {
    public static void main(String[] args) {
        CircularLinkedList ticketList = new CircularLinkedList();
        ticketList.addTicket("T001", "Alice", "Inception", "A1", "2023-10-01 18:00");
        ticketList.addTicket("T002", "Bob", "Avatar", "B2", "2023-10-01 20:00");
        ticketList.addTicket("T003", "Charlie", "Titanic", "C3", "2023-10-02 19:00");

        System.out.println("Current Tickets:");
        ticketList.displayTickets();

        System.out.println("\nSearching for ticket by Customer Name 'Bob':");
        Ticket foundTicket = ticketList.searchTicket("Bob");
        if (foundTicket != null) {
            System.out.println("Found Ticket: " + foundTicket.ticketId + ", Movie: " + foundTicket.movieName);
        } else {
            System.out.println("Ticket not found.");
        }

        System.out.println("\nTotal booked tickets: " + ticketList.countBookedTickets());

        System.out.println("\nRemoving ticket with ID 'T002'.");
        ticketList.removeTicket("T002");

        System.out.println("Current Tickets after removal:");
        ticketList.displayTickets();
    }
}
class Ticket {
    String ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularLinkedList {
    private Ticket head;
    private Ticket tail;

    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    public void removeTicket(String ticketId) {
        if (head == null) return;
        Ticket current = head;
        Ticket previous = tail;
        do {
            if (current.ticketId.equals(ticketId)) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) return;
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public Ticket searchTicket(String searchTerm) {
        if (head == null) return null;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public int countBookedTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}

