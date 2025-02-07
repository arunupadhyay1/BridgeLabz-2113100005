
public class AnimalTest {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
        
        Animal cat = new Cat();
        cat.makeSound();
        
        Animal bird = new Bird();
        bird.makeSound();
    }
}
class Animal {
    String name;
    int age;

    void makeSound() {}
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("Chirp");
    }
}
