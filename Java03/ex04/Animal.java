package ex04;

public abstract class Animal {
    protected Brain brain;

    public Animal(Brain brain) {
        this.brain = brain;
    }
    public void makeSound() {
    }
    public static void main(String[] args) {
        Animal nabi = new Dog(new Brain("nabi"));
        Animal choco = new Cat(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}

