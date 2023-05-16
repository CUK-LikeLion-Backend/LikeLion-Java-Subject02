package ex04;

public abstract class Animal {
    protected String name;
    protected Brain brain;

    public Animal(Brain brain) {
        this.brain = brain;
        this.name = brain.getName();
    }

    abstract void makeSound();

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}
