package ex04;

abstract public class Animal {
    protected Brain brain;
    Animal(Brain brain) {
        this.brain = brain;
    }
    abstract public void makeSound();
}
