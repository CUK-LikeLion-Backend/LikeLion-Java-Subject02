package ex04;

public class Cat extends Animal {
    public Cat(Brain brain) {
        super(brain.getName());
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + ": meow~~~");
    }

}
