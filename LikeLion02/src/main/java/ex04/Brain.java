package main.java.ex04;

public class Brain {
    String name;
    private Brain(String name) {
        this.name=name;
    }

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));
        nabi.makeSound();
        choco.makeSound();
    }
}
