package ex04;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public static void main(String[] args) {


        Dog dog = new Dog("choco");
        Cat cat = new Cat("nabi");

        dog.makeSound(); // 출력: "Bobby: bark!!!!"
        cat.makeSound(); // 출력: "Lucy: meow~~~"

        Brain brain = new Brain("Coco");

    }
}
