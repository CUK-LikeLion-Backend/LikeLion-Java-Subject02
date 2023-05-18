package ex04;

abstract class Animal {
    public abstract void makeSound();

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}
