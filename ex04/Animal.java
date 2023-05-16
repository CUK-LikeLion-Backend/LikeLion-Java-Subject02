package ex04;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();


    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}