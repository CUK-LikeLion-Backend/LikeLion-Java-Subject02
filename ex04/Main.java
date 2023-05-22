package ex04;

public class Main {
    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}

