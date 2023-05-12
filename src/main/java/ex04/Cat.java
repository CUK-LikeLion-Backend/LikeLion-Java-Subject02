package ex04;

public class Cat extends Animal {
    Cat (Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        System.out.println("\"" + brain.getName() + ": meow~~~\"" );
    }
}
