public class InventoryManagement {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addItemAtEnd("Apple", "001", 50, 0.5);
        inventory.addItemAtEnd("Banana", "002", 30, 0.2);
        inventory.addItemAtEnd("Orange", "003", 20, 0.3);
        inventory.addItemAtBeginning("Grapes", "004", 15, 1.0);
        
        // Display inventory
        System.out.println("Current Inventory:");
        inventory.displayInventory();

        // Update quantity
        inventory.updateItemQuantity("001", 60);
        System.out.println("\nAfter updating quantity of Apple:");
        inventory.displayInventory();

        // Remove an item
        inventory.removeItemById("002");
        System.out.println("\nAfter removing Banana:");
        inventory.displayInventory();

        // Search for an item
        InventoryItem searchedItem = inventory.searchItem("003");
        if (searchedItem != null) {
            System.out.println("\nSearched Item: " + searchedItem.itemName);
        } else {
            System.out.println("\nItem not found.");
        }

        // Calculate total value
        double totalValue = inventory.calculateTotalValue();
        System.out.println("\nTotal value of inventory: $" + totalValue);

        // Sort inventory by name
        inventory.sortInventory("name", true);
        System.out.println("\nInventory sorted by name:");
        inventory.displayInventory();

        // Sort inventory by price
        inventory.sortInventory("price", false);
        System.out.println("\nInventory sorted by price (descending):");
        inventory.displayInventory();
    }
}

class InventoryItem {
    String itemName;
    String itemId;
    int quantity;
    double price;
    InventoryItem next;

    public InventoryItem(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagementSystem {
    private InventoryItem head;

    public void addItemAtBeginning(String itemName, String itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, String itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    public void addItemAtPosition(String itemName, String itemId, int quantity, double price, int position) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        InventoryItem current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    public void removeItemById(String itemId) {
        if (head == null) return;

        if (head.itemId.equals(itemId)) {
            head = head.next;
            return;
        }

        InventoryItem current = head;
        while (current.next != null && !current.next.itemId.equals(itemId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Item not found");
        }
    }
	
    public void updateItemQuantity(String itemId, int newQuantity) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemId.equals(itemId)) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found");
    }

    public InventoryItem searchItem(String searchTerm) {
        InventoryItem current = head;
        while (current != null) {
            if (current.itemId.equals(searchTerm) || current.itemName.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        InventoryItem current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        return totalValue;
    }

    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private InventoryItem mergeSort(InventoryItem head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        InventoryItem middle = getMiddle(head);
        InventoryItem nextOfMiddle = middle.next;
        middle.next = null;

        InventoryItem left = mergeSort(head, criteria, ascending);
        InventoryItem right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private InventoryItem sortedMerge(InventoryItem left, InventoryItem right, String criteria, boolean ascending) {
        InventoryItem result = null;

        if (left == null) return right;
        if (right == null) return left;

        if (compare(left, right, criteria, ascending) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right, criteria, ascending);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, criteria, ascending);
        }
        return result;
    }

    private int compare(InventoryItem a, InventoryItem b, String criteria, boolean ascending) {
        int comparison = 0;
        if (criteria.equalsIgnoreCase("name")) {
            comparison = a.itemName.compareToIgnoreCase(b.itemName);
        } else if (criteria.equalsIgnoreCase("price")) {
            comparison = Double.compare(a.price, b.price);
        }

        return ascending ? comparison : -comparison;
    }

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null) return head;

        InventoryItem slow = head;
        InventoryItem fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        InventoryItem current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}

