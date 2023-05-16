package ex04;

public abstract class Animal {
    private String name;
    private Brain brain;

    public Animal(String name) {
        this.name = name;
        this.brain = new Brain(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
