package ex04;

public abstract class Animal {
    private Brain brain;

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    abstract void makeSound();
}
