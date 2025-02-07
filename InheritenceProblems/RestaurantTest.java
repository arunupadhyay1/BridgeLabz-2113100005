
public class RestaurantTest {
    public static void main(String[] args) {
        Chef chef = new Chef();
        chef.name = "Gordon";
        chef.performDuties();

        Waiter waiter = new Waiter();
        waiter.name = "John";
        waiter.performDuties();
    }
}
class Person {
    String name;
    int id;
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    public void performDuties() {
        System.out.println("Cooking food");
    }
}

class Waiter extends Person implements Worker {
    public void performDuties() {
        System.out.println("Serving food");
    }
}
