package main.java.ex04;

public class Brain {
    public Brain(String name) {
        System.out.printf("%s: ",name);
    }

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        nabi.makeSound();
        Animal choco = new Dog(new Brain("choco"));
        choco.makeSound();
    }
}
