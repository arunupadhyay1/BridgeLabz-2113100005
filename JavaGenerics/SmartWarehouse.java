import java.util.ArrayList;
import java.util.List;
public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<WarehouseItem> storage = new Storage<>();
        storage.addItem(new Electronics("Laptop"));
        storage.addItem(new Groceries("Apples"));
        storage.addItem(new Furniture("Chair"));

        storage.displayItems(storage.getItems());
    }
}

abstract class WarehouseItem {
    String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.name);
        }
    }
}

