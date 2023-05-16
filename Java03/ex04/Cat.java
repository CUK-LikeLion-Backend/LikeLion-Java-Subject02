package ex04;

public class Cat extends Animal {
    public Cat(Brain brain) {
        super(String.valueOf(brain));
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + ": meow~~~");
    }
}